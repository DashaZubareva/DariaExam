import com.cars.base.Car;
import com.cars.dao.DBConnect;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Sit on 28.09.2017.
 */
public class Start {
    public static void main(String[] args){

       try {
           DBConnect dbConnect = new DBConnect();
           List<Car> carList = dbConnect.getAll();
           System.out.println(carList.get(0));
           dbConnect.insertCar( 5000, "Rofftu", "pisdsnk");
           dbConnect.deleteCar(1);
           carList = dbConnect.getSold();
           for (Car car:carList
                ) {
               System.out.println(car);
           }
           System.out.println(carList.get(1));
         //  dbConnect.createTable();
       }
       catch(Exception e){
           e.printStackTrace();//все работает здесь
       }



    }
}
