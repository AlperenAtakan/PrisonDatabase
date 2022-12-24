public class Prisoner {
   private int prisonerID,weight,height,age,punishmenTime,gender;
   private String prisonerName,prisonerLastName,TC,releaseDate;

   private byte[] image;

    public Prisoner(int prisonerID,String prisonerName, String prisonerLastName, int height, int weight, String releaseDate, String TC, int age,int gender ,int punishmentTime , byte[] image) {
        this.prisonerID = prisonerID;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.punishmenTime = punishmenTime;
        this.prisonerName = prisonerName;
        this.prisonerLastName = prisonerLastName;
        this.gender = gender;
        this.TC = TC;
        this.releaseDate = releaseDate;
        this.image=image;
    }

    public int getPrisonerID() {
        return prisonerID;
    }

    public void setPrisonerID(int prisonerID) {
        this.prisonerID = prisonerID;
    }

    public int getWeight() {
        return weight;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPunishmenTime() {
        return punishmenTime;
    }

    public void setPunishmenTime(int punishmenTime) {
        this.punishmenTime = punishmenTime;
    }

    public String getPrisonerName() {
        return prisonerName;
    }

    public void setPrisonerName(String prisonerName) {
        this.prisonerName = prisonerName;
    }

    public String getPrisonerLastName() {
        return prisonerLastName;
    }

    public void setPrisonerLastName(String prisonerLastName) {
        this.prisonerLastName = prisonerLastName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getTC() {
        return TC;
    }

    public void setTC(String TC) {
        this.TC = TC;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}


