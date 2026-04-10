package bus_project;
import java.sql.*;
import java.util.Scanner;

class user_data{

    public String Person_name = "" ;
    public String Person_gender = "" ;
    public int Person_age  = 0 ;

    public void user_input(Scanner sc){

        System.out.print("enter the first name:");
        String f_name = sc.next() ;

        System.out.print("enter the last name:");
        String l_name = sc.next() ;

        Person_name = f_name + " " + l_name ;

        System.out.print("enter the gender(M/F):");
        Person_gender = sc.next() ;

        System.out.print("enter the age:");
        Person_age = sc.nextInt() ;
        
    }



}

   

class bus_data extends user_data {

    public int bus_seat_num = 0 ;
    public String bus_seat_prefer = "" ;
    public static final double bus_ticiket_price = 1300.0 ;

    // 1
    public static boolean[] bus_seat_right_window_upper = new boolean[5] ; // 1
    public static boolean[] bus_seat_right_upper_side = new boolean[5] ; // 2

    // 2
    public static boolean[] bus_seat_right_window_lower = new boolean[5] ; // 3
    public static boolean[] bus_seat_right_lower_side = new boolean[5] ; // 4

    // 3
    public static boolean[] bus_seat_left_window_upper = new boolean[5] ; // 5
    public static boolean[] bus_seat_left_window_lower = new boolean[5] ; // 6

    
    public void input_bus_data( user_data user_obj , Scanner sc){

        System.out.print("For right upper window and side seat(1) / For right lower window and side seat(2) / For left uper and lower seat(3):");
        int seat_side_chhose = sc.nextInt() ;
     

        if(seat_side_chhose == 1){

            System.out.print("Bus seat right window upper (1) / Bus seat right upper side (2):");
            int temp = sc.nextInt() ;

            if(temp == 1){
                bus_seat_prefer = "Bus Seat Right Window Upper" ;
            }
            else if(temp == 2){
                bus_seat_prefer = "Bus Seat Right Upper Side" ;
            }
            else{
                System.out.println("Wrong number press");
                return ;
            }

            System.out.print("Enter seat num(1-5):");
            bus_seat_num = sc.nextInt();
            bus_seat_num-- ;
            
            if(bus_seat_num == 0 || bus_seat_num < 5){
                user_obj.user_input(sc);
            }
            else{
                System.out.println("Wrong number press");
                return ;
            }

            
        }

        else if(seat_side_chhose == 2){

            System.out.print("Bus seat right window lower (1) / Bus seat right lower side (2):");
            int temp = sc.nextInt() ;

            if(temp == 1){
                bus_seat_prefer = "Bus Seat Right Window Lower" ;
            }
            else if(temp == 2){
                bus_seat_prefer = "Bus Seat Right Lower Side" ;
            }
            else{
               System.out.println("Wrong number press");
               return ;
            }

            System.out.print("Enter seat num(1-5):");
            bus_seat_num = sc.nextInt();
            bus_seat_num-- ;

            if(bus_seat_num == 0 || bus_seat_num < 5){
                user_obj.user_input(sc);
            }
            else{
                System.out.println("Wrong number press");
                return ;
            }
        }

        else if(seat_side_chhose == 3){

            System.out.print("Bus seat left window upper (1) / Bus seat left window lower (2):");
            int temp = sc.nextInt() ;
            if(temp == 1){ 
                bus_seat_prefer = "Bus Seat Left Window Upper" ;
            }
            else if(temp == 2){
                bus_seat_prefer = "Bus Seat Left Window Lower" ;
            }
            else{
                System.out.println("Wrong number press");
                return ;
            }

            System.out.print("Enter seat num(1-5):");
            bus_seat_num = sc.nextInt();
            bus_seat_num-- ;

            if(bus_seat_num == 0 || bus_seat_num < 5){
                user_obj.user_input(sc);
            }
            else{
                System.out.println("Wrong number press");
                return ;
            }
        }
        else{
            System.out.println("Wrong number press");
        }
    }

    public void find_which_seat_booked(String str , int num){
 
        switch (str) {
            case "bus_seat_right_window_upper":
                bus_seat_right_window_upper[num] = true;
                break;

            case "bus_seat_right_upper_side":
                bus_seat_right_upper_side[num] = true ;
                break ;

            case "bus_seat_right_window_lower":
                bus_seat_right_window_lower[num] = true ;
                break ;

            case "bus_seat_right_lower_side":
                bus_seat_right_lower_side[num] = true ;
                break ;

            case "bus_seat_left_window_upper":
                bus_seat_left_window_upper[num] = true ;
                break ;

            case "bus_seat_left_window_lower":
                bus_seat_left_window_lower[num] = true ;
                break ;

            default:
                break;
        }     
    } 

    public void total_seat(){
        int count_booked = 0 ;
        long count_empty = 0 ;

        for(int i = 0 ; i < bus_seat_right_window_upper.length ; i++){

            if(bus_seat_right_window_upper[i] == true){

                count_booked++ ;
            }
            else if(bus_seat_right_window_upper[i] == false){

                count_empty++ ;
            }
        }

        for(int i = 0 ; i < bus_seat_right_upper_side.length ; i++){

            if( bus_seat_right_upper_side[i] == true){
                count_booked++ ;
            }
            else if( bus_seat_right_upper_side[i] == false){
                count_empty++;
            }
        }

        for(int i = 0 ; i < bus_seat_right_window_lower.length ; i++){

            if(bus_seat_right_window_lower[i] == true){
               count_booked++ ;
            }
            else if(bus_seat_right_window_lower[i] == false){
                count_empty++;
            }
        }

        for(int i = 0 ; i < bus_seat_right_lower_side.length ; i++){

            if(bus_seat_right_lower_side[i] == true){
               count_booked++ ;
            }
            else if(bus_seat_right_lower_side[i] == false){
                count_empty++;
            }
        }

        for(int i = 0 ; i < bus_seat_left_window_upper.length ; i++){

            if(bus_seat_left_window_upper[i] == true){
               count_booked++ ;
            }
            else if(bus_seat_left_window_upper[i] == false){
                count_empty++;
            }
        }

        for(int i = 0 ; i < bus_seat_left_window_lower.length ; i++){

            if(bus_seat_left_window_lower[i] == true){
               count_booked++ ;
            }
            else if(bus_seat_left_window_lower[i] == false){
               count_empty++;
            }
        }

        System.out.println("Total seat avabile:"+count_empty );
        System.out.println("Total seat booked:"+count_booked );

    }

    public void fetech_seat_details_for_check(Connection conn , bus_data obj){

        try{
            String querry = "select * from bus_info" ;
            PreparedStatement preparedStatement = conn.prepareStatement(querry) ;
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String s = resultSet.getString("bus_seat_prefer") ;
                int num = resultSet.getInt("bus_seat_num") ;

                s = s.toLowerCase() ;
                s = s.replace(" ", "_") ;
                obj.find_which_seat_booked(s, num);
            }

        }
        catch( Exception e){
            System.out.println(e.getMessage());
        }


    }
    

    public boolean fetech_seat_details_for_check_befor_insert(Connection conn , String stx , int n){
        try{
            stx = stx.toLowerCase() ;
            stx = stx.replace(" ", "_") ;
            String querry = "select * from bus_info" ;
            PreparedStatement preparedStatement = conn.prepareStatement(querry) ;
            ResultSet resultSet = preparedStatement.executeQuery();
            

            while (resultSet.next()) {

                String str = resultSet.getString("bus_seat_prefer") ;
                int num = resultSet.getInt("bus_seat_num") ;

                str = str.toLowerCase() ;
                str = str.replace(" ", "_") ;

                if(str.equals(stx) && num == n){
                    return false ;
                }
            }

        }
        catch( Exception e){
            System.out.println(e.getMessage());
        }
        return true ;

    }

    public void querry_run_bus_info(Connection conn , bus_data obj , user_log_info obj_log_info ,  user_data user_obj , Scanner sc){

       
           
        System.out.print("Enter how many seat want to book(1/2):");
        int temp = sc.nextInt() ;
        sc.nextLine();

        if(temp == 1){
            try{


                obj.input_bus_data(user_obj , sc);
                    
                conn.setAutoCommit(false);

                String querry = "insert into bus_info( bus_seat_num , bus_seat_prefer , email_add) values (? , ? , ?)" ;
                PreparedStatement preparedStatement = conn.prepareStatement(querry) ;

                preparedStatement.setInt(1, obj.bus_seat_num);
                preparedStatement.setString(2, obj.bus_seat_prefer);

                preparedStatement.setString(3,obj_log_info.email_id );

                String querry2 = "insert into user_info( user_name , user_gender , user_age , email_add) values ( ? , ? , ? , ?) " ;
                PreparedStatement preparedStatement_2 = conn.prepareStatement(querry2) ;

                preparedStatement_2.setString(1, user_obj.Person_name );
                preparedStatement_2.setString(2,user_obj.Person_gender );
                preparedStatement_2.setInt(3, user_obj.Person_age);

                preparedStatement_2.setString(4,obj_log_info.email_id );
            
                if(fetech_seat_details_for_check_befor_insert(conn, obj.bus_seat_prefer , obj.bus_seat_num)){
                        
                    int effect_bus = preparedStatement.executeUpdate() ;
                    int effect_user = preparedStatement_2.executeUpdate();

                    if(effect_bus > 0 && effect_user > 0){
                        System.out.println("seat booked");
                        conn.commit();
                        conn.setAutoCommit(true);
                    }
                        
                }
                else{
                    System.out.println("the seat already booked:");
                }

                    
                preparedStatement.close();
                preparedStatement_2.close();
            }
            catch(Exception e){
                System.out.println(e.getMessage()); 
            }  

               
        }

        else if(temp == 2){
            try{


                String querry2 = "insert into user_info( user_name , user_gender , user_age , email_add) values ( ? , ? , ? , ?) " ;
                PreparedStatement preparedStatement_2 = conn.prepareStatement(querry2) ;

                String querry = "insert into bus_info( bus_seat_num , bus_seat_prefer , email_add) values (? , ? , ?) " ;
                PreparedStatement preparedStatement = conn.prepareStatement(querry) ;

                conn.setAutoCommit(false);


                int count = 0 ;
                    
                for(int i = 0 ; i < 2 ; i++){

                    obj.input_bus_data(user_obj , sc);  
                        
                    preparedStatement_2.setString(1, user_obj.Person_name );
                    preparedStatement_2.setString(2,user_obj.Person_gender );
                    preparedStatement_2.setInt(3, user_obj.Person_age);
                    preparedStatement_2.setString(4,obj_log_info.email_id );

                    preparedStatement.setInt(1, obj.bus_seat_num);
                    preparedStatement.setString(2, obj.bus_seat_prefer);
                    preparedStatement.setString(3, obj_log_info.email_id);

                    if(fetech_seat_details_for_check_befor_insert(conn, obj.bus_seat_prefer , obj.bus_seat_num)){
                        preparedStatement_2.executeUpdate() ;
                        preparedStatement.executeUpdate();
                        count++ ;
                    }
                }
                  
            

                    if(count == 2){
                        conn.commit();
                        conn.setAutoCommit(true);
                        System.out.println("both get booked:");
                        preparedStatement.close();
                    }
                    else if(count == 1){
                        conn.commit();
                        conn.setAutoCommit(true);
                        System.out.println("only one get booked other one is already booked");
                        preparedStatement.close();
                    }
                    else{
                        System.out.println("choosen seat already booked");
                    }  
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        else{
            System.out.println("enter which is mensation:");
        }
            
    }
      

    public void show_ticiket_details(Connection conn , user_log_info obj_Log_info){
        try{

            String query_log = "select * from log_info where email_add = ?" ;
            String query_bus = "select * from bus_info where email_add = ?" ;
            String query_user = "select * from user_info where email_add = ?" ;

            PreparedStatement preparedStatement_log = conn.prepareStatement(query_log) ;
            PreparedStatement preparedStatement_bus = conn.prepareStatement(query_bus) ;
            PreparedStatement preparedStatement_user = conn.prepareStatement(query_user) ;

            preparedStatement_log.setString(1, obj_Log_info.email_id);
            preparedStatement_bus.setString(1, obj_Log_info.email_id);
            preparedStatement_user.setString(1, obj_Log_info.email_id);

            ResultSet resultSet_log = preparedStatement_log.executeQuery() ;
            ResultSet resultSet_bus = preparedStatement_bus.executeQuery() ;
            ResultSet resultSet_user = preparedStatement_user.executeQuery() ;
           

            if(resultSet_user.next() && resultSet_log.next()){
                int temp_id = resultSet_log.getInt("user_id") ;

                System.out.printf("%-8s %-12s %-15s %-5s %-8s %-12s %-12s %-18s %-10s%n",
                    "user id", "booking id", "full name", "age", "gender",
                    "bus no", "from", "destination", "seat"
                );
                while (resultSet_bus.next()) {
                    
                    System.out.printf("%-8d %-12d %-15s %-5d %-8s %-12s %-12s %-18s %-10d%n",
                            temp_id,
                            resultSet_bus.getInt("booking_id"),
                            resultSet_user.getString("user_name"),
                            resultSet_user.getInt("user_age"),
                            resultSet_user.getString("user_gender"),
                            resultSet_bus.getString("bus_num"),
                            resultSet_bus.getString("bus_depart"),
                            resultSet_bus.getString("bus_destination"),
                            (resultSet_bus.getInt("bus_seat_num") + 1)
                    );
                }
            }
            else{
                System.out.println("you do not any ticiket booking:");
            }
           
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void ticiket_cancle(Connection conn , user_log_info obj_log_info){
        try{

            conn.setAutoCommit(false);
            String query_bus = "delete from bus_info where email_add = ?" ;
            String query_user = "delete from user_info where email_add = ?" ;

            PreparedStatement preparedStatement_bus = conn.prepareStatement(query_bus) ;
            PreparedStatement preparedStatement_user = conn.prepareStatement(query_user) ;

            preparedStatement_bus.setString(1, obj_log_info.email_id);
            preparedStatement_user.setString(1, obj_log_info.email_id);

            int effect_bus = preparedStatement_bus.executeUpdate() ;
            int effect_user = preparedStatement_user.executeUpdate() ;

            
            if(effect_bus > 0 && effect_user > 0){
                conn.commit();
                System.out.println("the ticiket is cancled");
            }
            else{
                System.out.println("the ticiket cancale failed");
            }



        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }



}





public class bus_system {

    public static void main(String[] args){

        


        try{
            Scanner sc = new Scanner(System.in) ;

            connect_paramiter obj_Connect_paramiter = new connect_paramiter() ;
            Connection conn = obj_Connect_paramiter.connect_database();

            user_log_info obj_log_info = new user_log_info() ;
            boolean row = obj_log_info.if_register_or_not(conn, obj_log_info);
            user_data obj_user_data = new user_data() ;
          
            if(row == true){
                bus_data bus_obj = new bus_data() ;

                bus_obj.fetech_seat_details_for_check(conn , bus_obj);
                bus_obj.total_seat(); 
                System.out.print("want to booked ticke press(1) / for show if you booked already (2) / if you want to cancle the ticiket (3):");
                int temp = sc.nextInt();
                if(temp == 1){
                    bus_obj.querry_run_bus_info(conn , bus_obj , obj_log_info , obj_user_data ,sc);
                }
                else if(temp == 2){
                    bus_obj.show_ticiket_details(conn, obj_log_info);
                }
                else if(temp == 3){
                    bus_obj.ticiket_cancle(conn, obj_log_info);
                }
                else{
                    System.out.println("worng number");
                }
            }
            else{
                System.out.println("somthig worng re login or re register");
            }
            sc.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }


       
    }
   
}
















