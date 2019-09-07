package afedorov;

import afedorov.entries.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainConnector implements AutoCloseable{
private Connection connection;

    public MainConnector(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Product[] findAll() {
        List<Product> products = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM internet_shop.product")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(String.valueOf(resultSet.getInt("id")));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                String sqlGetProducer = "SELECT name FROM internet_shop.producer WHERE id = ?";


                product.setProducer(resultSet.getString("producer"));
                product.setDescription(resultSet.getString("description"));

            }

        }

    }







}
