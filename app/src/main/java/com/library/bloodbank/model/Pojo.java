package com.library.bloodbank.model;

public class Pojo {

        private String number;
	    private String title;
	    private String description;

        	    public Pojo( String title, String description,String number) {
        	        this.title = title;
        	        this.description = description;
                    this.number = number;
        	    }



        	    public String getTitle() {
        	        return title;
        	    }

        	    public void setTitle(String title) {
        	        this.title = title;
        	    }

        	    public String getDescription() {
        	        return description;
        	    }

        	    public void setDescription(String description) {
        	        this.description = description;
        	    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
