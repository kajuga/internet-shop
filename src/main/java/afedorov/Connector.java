package afedorov;

import afedorov.entries.Product;
import afedorov.jdbc.ProductDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    static final String URL = "jdbc:postgresql://localhost:5432/internet_shop";
    static final String USER = "kajuga";
    static final String PASSWORD = "sashok";




    public static void main(String[] args) {


        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            ProductDAO productDAO = new ProductDAO(connection);
            Product product = new Product();
            product.setType("TV");
            product.setName("GOO-NEW");
            product.setProducer("SONY");
            product.setDescription("Flatron 55 inch, black");
            product.setPrice(2100.00);
            productDAO.create(product);




        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}


//    private int id;
//    private String type;
//    private String name;
//    private String producer;
//    private String description;
//    private double price;