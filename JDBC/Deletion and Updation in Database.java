import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class jdbc extends JFrame {
    private JTextField idField, nameField, addressField;
    private JButton insertButton, prevButton, nextButton, updateButton, deleteButton;
    private JLabel resultLabel;
    private Connection con;
    private ResultSet rs;

    public jdbc() {
        setTitle("JDBC Input Example");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        idField = new JTextField(10);
        nameField = new JTextField(10);
        addressField = new JTextField(10);

        insertButton = new JButton("Insert");
        prevButton = new JButton("Previous");
        nextButton = new JButton("Next");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        resultLabel = new JLabel("Result: ");

        add(new JLabel("ID:"));
        add(idField);
        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Address:"));
        add(addressField);
        add(insertButton);
        add(prevButton);
        add(nextButton);
        add(updateButton);
        add(deleteButton);
        add(resultLabel);

        insertButton.addActionListener(new InsertAction());
        prevButton.addActionListener(new PrevAction());
        nextButton.addActionListener(new NextAction());
        updateButton.addActionListener(new UpdateAction());
        deleteButton.addActionListener(new DeleteAction());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            loadFirstRecord();
        } catch (Exception e) {
            resultLabel.setText("Error: " + e.getMessage());
        }
    }

    private void loadFirstRecord() {
        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM emp");
            if (rs.next()) {
                displayRecord();
            } else {
                resultLabel.setText("No records found.");
            }
        } catch (SQLException e) {
            resultLabel.setText("Error: " + e.getMessage());
        }
    }

    private void displayRecord() throws SQLException {
        idField.setText(String.valueOf(rs.getInt(1)));
        nameField.setText(rs.getString(2));
        addressField.setText(rs.getString(3));
    }

    private class InsertAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String address = addressField.getText();

                PreparedStatement psmt = con.prepareStatement("INSERT INTO emp VALUES (?, ?, ?)");
                psmt.setInt(1, id);
                psmt.setString(2, name);
                psmt.setString(3, address);

                psmt.execute();
                psmt.close();

                resultLabel.setText("Inserted record.");
                clearFields();
                loadFirstRecord();

            } catch (SQLIntegrityConstraintViolationException ex) {
                resultLabel.setText("ID must be unique: " + ex.getMessage());
            } catch (Exception ex) {
                resultLabel.setText("Error: " + ex.getMessage());
            }
        }
    }

    private class PrevAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (rs.previous()) {
                    displayRecord();
                } else {
                    resultLabel.setText("No previous record.");
                }
            } catch (SQLException ex) {
                resultLabel.setText("Error: " + ex.getMessage());
            }
        }
    }

    private class NextAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (rs.next()) {
                    displayRecord();
                } else {
                    resultLabel.setText("No next record.");
                }
            } catch (SQLException ex) {
                resultLabel.setText("Error: " + ex.getMessage());
            }
        }
    }

    private class UpdateAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String address = addressField.getText();

                PreparedStatement psmt = con.prepareStatement("UPDATE emp SET name = ?, address = ? WHERE id = ?");
                psmt.setString(1, name);
                psmt.setString(2, address);
                psmt.setInt(3, id);

                int rowsAffected = psmt.executeUpdate();
                psmt.close();

                if (rowsAffected > 0) {
                    resultLabel.setText("Updated record.");
                    loadFirstRecord();
                } else {
                    resultLabel.setText("Record not found.");
                }
            } catch (Exception ex) {
                resultLabel.setText("Error: " + ex.getMessage());
            }
        }
    }

    private class DeleteAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int id = Integer.parseInt(idField.getText());

                PreparedStatement psmt = con.prepareStatement("DELETE FROM emp WHERE id = ?");
                psmt.setInt(1, id);

                int rowsAffected = psmt.executeUpdate();
                psmt.close();

                if (rowsAffected > 0) {
                    resultLabel.setText("Deleted record.");
                    clearFields();
                    loadFirstRecord();
                } else {
                    resultLabel.setText("Record not found.");
                }
            } catch (Exception ex) {
                resultLabel.setText("Error: " + ex.getMessage());
            }
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        addressField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            jdbc frame = new jdbc();
            frame.setVisible(true);
        });
    }
}
