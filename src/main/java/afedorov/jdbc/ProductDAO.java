package afedorov.jdbc;

import afedorov.entries.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Author : Aleksandr Fedorov
 */
public class ProductDAO implements DAO<Product, String> {
    /**
     * Connection to database.
     */
    private final Connection connection;

    /**
     * Init database connection.
     * @param connection of database.
     */
    public ProductDAO(final Connection connection) {
        this.connection = connection;
    }

    /**
     * Create Product in database.
     * @param product for create.
     * @return false if User already exist. If creating success true.
     */

    public boolean create(final Product product) {
        boolean result = false;

        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO internet_shop.products (type, name, producer, description, price) VALUES ((?), (?), (?), (?), (?))")) {
            statement.setString(1, product.getType());
            statement.setString(2, product.getName());
            statement.setString(3, product.getProducer());
            statement.setString(4, product.getDescription());
            statement.setDouble(5, product.getPrice());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Product> findAll(){

    }

    /**
     * Select Product by id.
     *
//     * @param id for select.
     * @return return valid entity if she exist. If entity does not exist return empty Product with id = -1.
     */
    @Override
    public Product read(final String login) {
        final Product result = new Product();
        result.setId(-1);

//        try (PreparedStatement statement = connection.prepareStatement(SQLUser.GET.QUERY)) {
//            statement.setString(1, login);
//            final ResultSet rs = statement.executeQuery();
//            if (rs.next()) {
//                result.setId(Integer.parseInt(rs.getString("id")));
//                result.setLogin(login);
//                result.setPassword(rs.getString("password"));
//                result.setRole(new Product().Role(rs.getInt("rol_id"), rs.getString("role")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return result;
    }

    /**
     * Update User's password by id.
     *
     * @param user new user's state.
     * @return True if success. False if fail.
     */
    @Override
    public boolean update(final Product user) {
        boolean result = false;

        try (PreparedStatement statement = connection.prepareStatement(SQLProduct.UPDATE.QUERY)) {
            statement.setString(1, user.getProducer());
            statement.setInt(2, user.getId());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Delete User by id AND login AND password.
     *
     * @param user for delete.
     * @return true if User was deleted. False if User not exist.
     */
    @Override
    public boolean delete(final Product user) {
        boolean result = false;

        try (PreparedStatement statement = connection.prepareStatement(SQLProduct.DELETE.QUERY)) {
            statement.setInt(1, user.getId());
            statement.setString(2, user.getProducer());
            statement.setString(3, user.getProducer());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * SQL queries for users table.
     */
    enum SQLProduct {
        GET("SELECT u.id, u.login, u.password, r.id AS rol_id, r.role FROM users AS u LEFT JOIN roles AS r ON u.role = r.id WHERE u.login = (?)"),

        INSERT("INSERT INTO products (type, name, producer, description, price) VALUES ((?), (?), (?), (?), (?))"),

        DELETE("DELETE FROM users WHERE id = (?) AND login = (?) AND password = (?) RETURNING id"),
        UPDATE("UPDATE users SET password = (?) WHERE id = (?) RETURNING id");

        String QUERY;

        SQLProduct(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}