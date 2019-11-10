package org.insset.client.pourcentage;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
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
import org.insset.client.service.PourcentageService;
import org.insset.client.service.PourcentageServiceAsync;


public class CalculatorPourcentage extends Composite {

    interface MainUiBinder extends UiBinder<HTMLPanel, CalculatorPourcentage> {}

    @UiField
    public ResetButton boutonCleanPourcentage;

    @UiField
    public SubmitButton boutonCalPourcentage;

    @UiField
    public TextBox valeurMontant;

    @UiField
    public TextBox valeurRemise;

    @UiField
    public ResetButton boutonCleanInversePourcentage;

    @UiField
    public SubmitButton boutonInversePourcentage;

    @UiField
    public TextBox valeurPrice;

    @UiField
    public TextBox valeurDiscount;
    
    @UiField
    public Label errorCalPourcentage;
    
    @UiField
    public Label errorInversePourcentage;

    private static MainUiBinder ourUiBinder = GWT.create(MainUiBinder.class);

    private final PourcentageServiceAsync service = GWT.create(PourcentageService.class);

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
                errorCalPourcentage.setText(" ");
            }
        });

        boutonCalPourcentage.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                getFinalPrice();
            }
        });

        valeurMontant.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                valeurMontant.setText("");
            }
        });

        valeurRemise.addDoubleClickHandler(new DoubleClickHandler() {

            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                valeurRemise.setText("");
            }     
        });
        
        
        boutonInversePourcentage.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
               getInitialPrice();
            }
        });
        
        valeurPrice.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                valeurPrice.setText("");
            }
        });

           valeurDiscount.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                valeurDiscount.setText("");
            }
        });
           
           boutonCleanInversePourcentage.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                valeurDiscount.setText("");
                valeurPrice.setText("");
                errorInversePourcentage.setText(" ");
            }
        });
    }

    public void getFinalPrice() {
        double finalPrice = 0;
        double discount   = 0;
            
        try{
            finalPrice = Double.parseDouble(valeurMontant.getText());
            discount = Double.parseDouble(valeurRemise.getText());
            
        }
         catch(Exception e){
             errorCalPourcentage.addStyleName("serverResponseLabelError");
             errorCalPourcentage.setText("Format incorect. Verfier les Champs!!");
            return;    
         }
        
            service.getFinalPrice(finalPrice, discount, new AsyncCallback<Double>() {
            
            @Override
            public void onFailure(Throwable caught) {
               
                errorCalPourcentage.addStyleName("serverResponseLabelError");
                errorCalPourcentage.setText("L'un de vos champs est incorrect. Prix superieur a 0 et Remise comprise entre 0 et 100.");
            }
            
            @Override
            public void onSuccess(Double result) {
                errorCalPourcentage.setText(" ");
                new DialogBoxInssetPresenter("Prix avec la reduction", "Prix final", String.valueOf(result));
            }            
        });
 }
    

    public void getInitialPrice() {
        double finalPrice = 0;
        double discount   = 0;

        try{
            finalPrice = Double.parseDouble(valeurPrice.getText());
            discount = Double.parseDouble(valeurDiscount.getText());
            }
        catch(Exception e){
             errorInversePourcentage.addStyleName("serverResponseLabelError");
             errorInversePourcentage.setText("Format incorect. Verfier les Champs!!");
            return;    
         }
            
            service.getInitialPrice(finalPrice, discount, new AsyncCallback<Double>() {
            
            @Override
            public void onFailure(Throwable caught) {
                errorInversePourcentage.addStyleName("serverResponseLabelError");
                errorInversePourcentage.setText("Erreur sur l'un de vos champs. Prix superieur a 0 et Remise comprise entre 0 et 100.");
            }
            
            @Override
            public void onSuccess(Double result) {
                errorInversePourcentage.setText(" ");
                new DialogBoxInssetPresenter("Prix initial avant reduction","Prix initial",String.valueOf(result));
            }          
        });
    }
}
