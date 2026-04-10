package bus_project;
import java.sql.*;
import java.util.Scanner; 

class user_log_info{
    Scanner sc = new Scanner(System.in) ;
    public String first_name = "" ;
    public String last_name = "" ;
    public String email_id = "" ;
    public String password  = "" ;

    public void input_set_register(){

        System.out.print("Enter the first name:");
        first_name = sc.nextLine() ;
        System.out.print("Enter the last name:");
        last_name = sc.nextLine() ;

        System.out.print("Enter the email:");
        email_id = sc.nextLine();

        System.out.print("Enter the password:");
        password = sc.nextLine();


        
       
    }

    public void input_set_login(){

        System.out.print("Enter Email id:");
        email_id = sc.nextLine() ;

        System.out.print("Enter the password:");
        password = sc.nextLine();  
       
    }

    public boolean if_register_or_not(Connection conn , user_log_info obj){
        
        System.out.print("IF YOU ARE FIRST TIME IN THIS SITE (Y/N):");
        String chooise = sc.nextLine() ;

        if(chooise.toUpperCase().equals("Y")){
            
            obj.input_set_register();
            boolean effect = querry_run_register(conn , obj) ;

            if(effect == true){
               
                return true ;
            }
        }
        else if((chooise.toUpperCase().equals("N"))){
            System.out.println("Enter your log in information:");
            obj.input_set_login();
            boolean effect = querry_run_login(conn, obj) ;

            if(effect == true){
               
                return true ;
            }
        }
        else{
            System.out.println(" enter which is mensation");
        }
       
        return false ;
       
        
    }

    
    public boolean querry_run_register(Connection conn , user_log_info obj){
        try{
            
            String querry_2 = "select email_add from log_info where email_add = ?" ;  
            PreparedStatement preparedStatement_2 = conn.prepareStatement(querry_2) ;
            preparedStatement_2.setString(1, obj.email_id);   
            ResultSet result = preparedStatement_2.executeQuery() ;
            
                
            if(!result.next()) {
                    
                String querry = "insert into log_info ( first_name , last_name , email_add , password ) values ( ? , ? , ?  , ?)" ;
                PreparedStatement preparedStatement = conn.prepareStatement(querry) ;

                if( obj.email_id != null && obj.email_id.endsWith("@gmail.com")){
                    preparedStatement.setString(1, obj.first_name);
                    preparedStatement.setString(2, obj.last_name);
                    preparedStatement.setString(3, obj.email_id);
                    preparedStatement.setString(4, obj.password);
                            
                    int temp = preparedStatement.executeUpdate();
                    if(temp > 0) {
                        return true ;
                    }
                    else {
                        return false;
                    }
                }
                        
                    
            }
            else {
                String checkString = result.getString("email_add") ;
                if(checkString.equals(obj.email_id)) {
                    return false ;
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false ;
    }

    
    public boolean querry_run_login(Connection conn , user_log_info obj){
        try{
            String querry = "select email_add , password from log_info where email_add = ?" ;
            PreparedStatement preparedStatement = conn.prepareStatement(querry) ;
            preparedStatement.setString(1, obj.email_id);
            ResultSet result = preparedStatement.executeQuery() ;

            if(result.next()){
                String user_name = result.getString("email_add") ;
                String pas_word = result.getString("password") ;
                if(user_name.equals(obj.email_id) && pas_word.equals(obj.password)){
                    return true ;
                }
            }
        }
        catch( Exception e ){
            System.out.println(e.getMessage());
        }
        return false ;
    }
}

class connect_paramiter{
    public static final String url = "jdbc:mysql://localhost:3306/bus_project" ;
    public static final String name = "root" ;
    public static final String password = "k664fepx@123" ;

    public Connection connect_database(){
        Connection conn = null ;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver") ;
            conn = DriverManager.getConnection( url , name , password);
            return conn ;
        }
        catch( Exception e){
            System.out.println(e.getMessage());
        }
        return null ;
    }
}





