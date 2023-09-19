/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.ejb.DriverFacadeLocal;
import com.udea.modelo.Driver;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 *
 * @author Sebastian
 */
public class DriverBean {

    @EJB
    private com.udea.ejb.DriverFacadeLocal driverFacade;
    
    public UIComponent myButton;
    private Integer id;
    private String firstName;
    private String lastName;
    private String IDNumber;  
    private Date birthDate = new Date();
    private String phone;
    private String email;
    private String password; 
    private String txtPasswordRepeat;
    private String brand;     
    private String model;
    private String licensePlate;
    
    boolean disable = true;

    private List<Driver> drivers; // Para visualizar en el DataTable de JSF
    
    // Retorna una lista de clientes para mostrar en el DataTable
    public List<Driver> getDrivers(){
        if (drivers == null || drivers.isEmpty())
            refresh();
        return drivers;
    }
    
    public void refresh(){
        drivers = driverFacade.getAllDrivers();
    }
    
    public UIComponent getMyButton() {
        return myButton;
    }

    public void setMyButton(UIComponent myButton) {
        this.myButton = myButton;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTxtPasswordRepeat() {
        return txtPasswordRepeat;
    }

    public void setTxtPasswordRepeat(String txtPasswordRepeat) {
        this.txtPasswordRepeat = txtPasswordRepeat;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
    
    /**
     * Creates a new instance of DriverBean
     */
    public DriverBean() {
    }
    
    public String guardar(){
        Driver d = new Driver();
        d.setId(id);
        d.setFirstName(firstName);
        d.setLastName(lastName);
        d.setIDNumber(IDNumber);
        d.setBirthDate(birthDate);
        d.setPhone(phone);
        d.setEmail(email);
        d.setPassword(password);
        d.setBrand(brand);
        d.setModel(model);
        d.setPlate(licensePlate);
        
        this.driverFacade.create(d);
        
        return "DriverCreate";
    }
    
    public String validar(){
        /*String sCadena;
        sCadena= String.valueOf(card);
        sSubCadena = sCadena.substring(0,4);
        int val= Integer.parseInt(sCadena);      

        if(val>=0000 && val<= 5555){
          FacesMessage message = new FacesMessage("TARJETA VISA");
          FacesContext context= FacesContext.getCurrentInstance();
          context.addMessage(myButton.getClientId(context), message);
          mensajecard = "ES VISA";
          disable=false;
          this.setMensajecard(mensajecard);
          return this.getMensajecard();        
        } else if(val>=8000 && val<= 9999){
          FacesMessage message = new FacesMessage("TARJETA MASTERCARD");
          FacesContext context= FacesContext.getCurrentInstance();
          context.addMessage(myButton.getClientId(context), message);
          mensajecard = "ES MASTERCARD";
          disable=false;
          this.setMensajecard(mensajecard);
          return this.getMensajecard();         
        } else{
           FacesMessage message = new FacesMessage("TARJETA INVALIDA");
          FacesContext context= FacesContext.getCurrentInstance();
          context.addMessage(myButton.getClientId(context), message);
        }*/
        disable = false;
        return null;
    }
    
    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    
    public Locale getLocale(){
        return locale;
    }
    
    public String getLanguage(){
        return locale.getLanguage();
    }
    
    public void changeLanguage(String language){
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
    }
}
