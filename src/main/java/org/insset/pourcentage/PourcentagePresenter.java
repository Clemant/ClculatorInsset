package org.insset.client.pourcentage;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ResetButton;
import com.google.gwt.user.client.ui.SubmitButton;
import com.google.gwt.user.client.ui.TextBox;
import org.insset.client.message.dialogbox.DialogBoxInssetPresenter;
import org.insset.client.service.PourcentageService;          /*Inutile pour la page pourcentage*/
import org.insset.client.service.PourcentageServiceAsync;          /*Inutile pour la page pourcentage*/
import org.insset.shared.FieldVerifier;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author talend
 */
public class PourcentagePresenter extends Composite {

    @UiField
    public ResetButton boutonClearR;          /*CLear les textes ValR et ValE*/
    @UiField
    public SubmitButton boutonConvertRToA;          /*Inutile pour la page pourcentage*/
    @UiField
    public ResetButton boutonClearA;          /*CLear les textes ValA et ValF*/
    @UiField
    public SubmitButton boutonConvertAToR;          /*Inutile pour la page pourcentage*/
    @UiField
    public ResetButton boutonClearD;          /*Inutile pour la page pourcentage*/
    @UiField
    public SubmitButton boutonConvertD;          /*Inutile pour la page pourcentage*/
    @UiField
    public TextBox valR;          /*Zone de texte du prix de départ*/
    @UiField
    public TextBox valA;          /*Zone de texte du montant final et dont on veut connaître le prix d'origine*/
    @UiField
    public TextBox valD;          /*Inutile pour la page pourcentage*/
    @UiField
    public Label errorLabelRToA;          /*Message d'erreur*/
    @UiField
    public Label errorLabelAToR;          /*Message d'erreur*/
    @UiField
    public Label errorLabelD;          /*Inutile pour la page pourcentage*/
    @UiField
    public Label valE;          /*Zone de texte d'un pourcentage de remise*/
    @UiField
    public Label valF;          /*Zone de texte d'un pourcentage de remise effectué sur un prix final*/

    interface MainUiBinder extends UiBinder<HTMLPanel, PourcentagePresenter> {
    }

    private static MainUiBinder ourUiBinder = GWT.create(MainUiBinder.class);
    /**
     * Create a remote service proxy to talk to the server-side Greeting
     * service.
     */
    private final PourcentageServiceAsync service = GWT.create(PourcentageService.class);

    /**
     * Constructeur
     */
    public PourcentagePresenter() {
        initWidget(ourUiBinder.createAndBindUi(this));
        initHandler();
    }

    /**
     * Init des handler
     */
    private void initHandler() {
        boutonClearR.addClickHandler(new ClickHandler() {                /*Bouton qui permet de clear la zone de texte 1 et 2 soit ValR et ValE*/
            @Override
            public void onClick(ClickEvent event) {
                valR.setText("");
                valE.setText("");
                errorLabelRToA.setText("");
            }
        });
        boutonConvertRToA.addClickHandler(new ClickHandler() {           /*Doit être changer en fonction pour faire en sorte*/
            @Override                                                    /*qu'une remise soit appliqué à un montant, VOIR LIGNE 131 - 146 pour le message d'erreur*/
            public void onClick(ClickEvent event) {
                getPourcentage();
            }

        });
        boutonClearA.addClickHandler(new ClickHandler() {                /*Bouton qui permet de clear la zone de texte 3 et 4 soit ValA et ValF*/
            @Override
            public void onClick(ClickEvent event) {
                valA.setText("");
                valF.setText("");
                errorLabelAToR.setText("");
            }
        });
        boutonConvertAToR.addClickHandler(new ClickHandler() {            /*Doit être changer en fonction pour faire en sorte de connaître le prix de départ*/
            @Override                                                     /*d'un montant ayant subit une remise, VOIR LIGNE 153 - 165 pour le message d'erreur*/
            public void onClick(ClickEvent event) {
                convertArabeToRoman();
            }

        });
        boutonClearD.addClickHandler(new ClickHandler() {          /*Inutile pour la page pourcentage*/
            @Override
            public void onClick(ClickEvent event) {
                valD.setText("");
                errorLabelD.setText("");
            }
        });
        boutonConvertD.addClickHandler(new ClickHandler() {          /*Inutile pour la page pourcentage*/
            @Override
            public void onClick(ClickEvent event) {
                convertDate();
            }

        });
    }

    /**
     * call server
     */
    private void getPourcentage() {
        
        if (!FieldVerifier.isValidPrice(valR.getText())) {
            errorLabelRToA.addStyleName("serverResponseLabelError");
            errorLabelRToA.setText("Format incorect");
            return;
        }
        service.pourcentage(valR.getText(),"borne",  new AsyncCallback<String>() {
            public void onFailure(Throwable caught) {
                // Show the RPC error message to the user
//                Window.alert(SERVER_ERROR);
            }

            public void onSuccess(String result) {
                errorLabelRToA.setText(" ");
                new DialogBoxInssetPresenter("Convertion Roman to arabe", valR.getText(), String.valueOf(result));
            }

            
        });
    }

    /**
     * call server
     */
    private void convertArabeToRoman() {
        Integer value = null;
        try {
            value = Integer.parseInt(valA.getText());
        } catch (NumberFormatException e) {
            errorLabelAToR.addStyleName("serverResponseLabelError");
            errorLabelAToR.setText("Format incorect");
            return;
        }
        if (!FieldVerifier.isValidDecimal(value)) {
            errorLabelAToR.addStyleName("serverResponseLabelError");
            errorLabelAToR.setText("Format incorect");
            return;
        }
        /*  service.convertArabeToRoman(Integer.parseInt(valA.getText()), new AsyncCallback<String>() {
            public void onFailure(Throwable caught) {
                // Show the RPC error message to the user
            }

            public void onSuccess(String result) {
                errorLabelAToR.setText(" ");
                new DialogBoxInssetPresenter("Convertion Arabe to Roman", valA.getText(), result);
            }
        });*/
    }

    /**
     * call server
     */
    private void convertDate() {
        //Verif
        if (!FieldVerifier.isValidDate(valD.getText())) {
            errorLabelAToR.addStyleName("serverResponseLabelError");
            errorLabelAToR.setText("Format incorect");
            return;
        }
        //call server
       /* service.convertDateYears(valD.getText(), new AsyncCallback<String>() {
            public void onFailure(Throwable caught) {
                // Show the RPC error message to the user
//                Window.alert(SERVER_ERROR);
            }

            public void onSuccess(String result) {
                errorLabelD.setText(" ");
                new DialogBoxInssetPresenter("Convertion Date", valD.getText(), result);
            }
        });*/
    }

}
