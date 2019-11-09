/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.pourcentage;

/**
 *
 * @author victoire
 * 
 */

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyEvent;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
//import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ResetButton;
import com.google.gwt.user.client.ui.SubmitButton;
import com.google.gwt.user.client.ui.TextBox;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.insset.client.message.dialogbox.DialogBoxInssetPresenter;
import org.insset.client.service.PourcentageService;
import org.insset.client.service.PourcentageServiceAsync;

//import org.insset.client.service.PourcentageService;          /*Inutile pour la page pourcentage*/
//import org.insset.client.service.PourcentageServiceAsync;          /*Inutile pour la page pourcentage*/
import org.insset.shared.FieldVerifier;

public class CalculatorPourcentage extends Composite {

    interface MainUiBinder extends UiBinder<HTMLPanel, CalculatorPourcentage> {

    }

    // Attribute for the first exercice
    @UiField
    public ResetButton boutonCleanPourcentage;

    @UiField
    public SubmitButton boutonCalPourcentage;

    @UiField
    public TextBox valeurMontant;

    @UiField
    public TextBox valeurRemise;

    // Attribute for the second exercice
    @UiField
    public ResetButton boutonCleanInversePourcentage;

    @UiField
    public SubmitButton boutonInversePourcentage;

    @UiField
    public TextBox valeurPrice;

    @UiField
    public TextBox valeurDiscount;

    private static MainUiBinder ourUiBinder = GWT.create(MainUiBinder.class);

    private final PourcentageServiceAsync service = GWT.create(PourcentageService.class);

    private static Logger rootLogger = Logger.getLogger("");

    public CalculatorPourcentage() {
        initWidget(ourUiBinder.createAndBindUi(this));
        initHandler();
    }

    private void initHandler() {
        boutonCleanPourcentage.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                valeurMontant.setText("");
                valeurRemise.setText("");
            }
        });

        boutonCalPourcentage.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                // TODO Auto-generated method stub
                rootLogger.log(Level.INFO, "Appel de la methode");

            }
        });

        valeurMontant.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                valeurMontant.setText("");
            }
        });

        valeurRemise.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                valeurRemise.setText("");
            }
        });

    }

    // Retour le prix final avec la remise
    public void getInitialPrice() {
    }

    // Retour le prix inital sans la remise
    public void getFinalPrice() {

    }
}
