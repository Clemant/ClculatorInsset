package org.insset.client.pourcentage;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
public class PourcentPresenter extends Composite {

    
     //@UiTemplate("PourcentagePresenter.ui.xml")
    interface MainUiBinder extends UiBinder<HTMLPanel,PourcentPresenter>{

    }
    @UiField
    public ResetButton boutonCleanPourcentage;

    @UiField
    public SubmitButton boutonCalPourcentage;
    
    @UiField
    public TextBox valeurMontant;

    @UiField
    public TextBox valeurRemise;

    
    private static MainUiBinder ourUiBinder = GWT.create(MainUiBinder.class);
     
    private final PourcentageServiceAsync service  = GWT.create(PourcentageService.class);

    public PourcentPresenter(){
        initWidget(ourUiBinder.createAndBindUi(this));
        initHandler();
    }

    

    
    private void initHandler(){
        boutonCleanPourcentage.addClickHandler(new ClickHandler(){
            @Override
            public void onClick(ClickEvent event){

            }
        });
    }
    
    
}
