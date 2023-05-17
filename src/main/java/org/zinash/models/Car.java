package org.zinash.models;

public class Car {
   private int plateNo;
   private String carName;
   private int fYear;
   private String country;
   private String model;
   private int Price;

   private int fkpersonid;

//No args

   public Car() {
   }


//All args

   public Car(int plateNo, String carName, int fYear, String country, String model, int price, int fkpersonid) {
      this.plateNo = plateNo;
      this.carName = carName;
      this.fYear = fYear;
      this.country = country;
      this.model = model;
      Price = price;
      this.fkpersonid = fkpersonid;
   }


//Some args(Except personId)

   public Car(String carName, int fYear, String country, String model, int price, int fkpersonid) {
      this.carName = carName;
      this.fYear = fYear;
      this.country = country;
      this.model = model;
      Price = price;
      this.fkpersonid = fkpersonid;
   }


//To string

   @Override
   public String toString() {
      return "Car{" +
              "plateNo=" + plateNo +
              ", carName='" + carName + '\'' +
              ", fYear=" + fYear +
              ", country='" + country + '\'' +
              ", model='" + model + '\'' +
              ", Price=" + Price +
              ", fkpersonid=" + fkpersonid +
              '}';
   }


   //Getter and setter


   public int getPlateNo() {
      return plateNo;
   }

   public void setPlateNo(int plateNo) {
      this.plateNo = plateNo;
   }

   public String getCarName() {
      return carName;
   }

   public void setCarName(String carName) {
      this.carName = carName;
   }

   public int getfYear() {
      return fYear;
   }

   public void setfYear(int fYear) {
      this.fYear = fYear;
   }

   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public String getModel() {
      return model;
   }

   public void setModel(String model) {
      this.model = model;
   }

   public int getPrice() {
      return Price;
   }

   public void setPrice(int price) {
      Price = price;
   }

   public int getFkpersonid() {
      return fkpersonid;
   }

   public void setFkpersonid(int fkpersonid) {
      this.fkpersonid = fkpersonid;
   }
}









