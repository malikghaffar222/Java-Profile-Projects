
public class Date212 {
    
    int year, month, day;
    
    String date;
    
    public Date212(String date){
        year = Integer.parseInt(date.substring(0, 4));
        month = Integer.parseInt(date.substring(4, 6));
        day = Integer.parseInt(date.substring(6, 8));
        this.date = date;
        

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Date212 other = (Date212) obj;
        if (this.year != other.year) {
            return false;
        }
        if (this.month != other.month) {
            return false;
        }
        if (this.day != other.day) {
            return false;
        }
        return true;
    }
    
    
    public int compareTo(Date212 o)
    {
        if (Integer.parseInt(date) > Integer.parseInt(o.date)) {
            return 1;
        }
        else if (Integer.parseInt(date) < Integer.parseInt(o.date)) {
            return -1;
        }
        else {
            return 0;
        }
    }
    
    
    
    public String toString(){
        
        String str="";
        
        switch(month){
            case 1:
                str+= "January";
                break;
            case 2:
                 str+= "February";
                break;
            case 3:
                 str+= "March";
                break;
            case 4:
                 str+= "April";
                break;
            case 5:
                 str+= "May";
                break;
            case 6:
                 str+= "June";
                break;
            case 7:
                 str+= "July";
                break;
            case 8:
                 str+= "August";
                break;
            case 9:
                 str+= "September";
                break;
            case 10:
                 str+= "October";
                break;
            case 11:
                 str+= "Novermber";
                break;
            case 12:
                 str+= "December";
                break;
               
        }
        
        str+=" "+day+", "+year;
        
        return str;
    }
    
}
