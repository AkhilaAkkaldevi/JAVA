package atm_machine;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import atm_machine.AtmmachinDto;
import atm_machine.ConnectionFactory;

public class atmmachineDao {
	Double balance;

    public int withdraw(AtmmachinDto dto) throws IOException, SQLException {
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement st = con.prepareStatement("UPDATE atm SET balance = balance - ? WHERE accno = ? AND pin = ?");
             PreparedStatement st2 = con.prepareStatement("SELECT balance FROM atm WHERE accno = ? AND pin = ?")) {

            st2.setInt(1, dto.getAccno());
            st2.setInt(2, dto.getPin());

            ResultSet query = st2.executeQuery();

            if (query.next()) {
                balance = query.getDouble("balance");
                if (balance >= dto.getAmount()) {
                    st.setInt(1, dto.getAmount());
                    st.setInt(2, dto.getAccno());
                    st.setInt(3, dto.getPin());
                    int update = st.executeUpdate();
                    return update > 0 ? 1 : 0; // Return 1 for success
                } else {
                    return 0; // Insufficient balance
                }
            }
            return 2; // Account or PIN mismatch
        }
    }

    public int deposit(AtmmachinDto dto) throws IOException, SQLException {
    	try (Connection con = ConnectionFactory.getConnection();
                PreparedStatement st = con.prepareStatement("UPDATE atm SET balance = balance + ? WHERE accno = ? AND pin = ?");
                ) {

              

             
                       st.setInt(1, dto.getAmount());
                       st.setInt(2, dto.getAccno());
                       st.setInt(3, dto.getPin());
                       int update = st.executeUpdate();
                       return update > 0 ? 1 : 0; // Return 1 for success
                  
               }
                // Account or PIN mismatch
           }
    public int transfer(AtmmachinDto dto) throws IOException, SQLException {
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement st = con.prepareStatement("UPDATE atm SET balance = balance - ? WHERE accno = ? AND pin = ?");
             PreparedStatement st2 = con.prepareStatement("UPDATE atm SET balance = balance + ? WHERE accno = ? ")) {

           
                    st.setInt(1, dto.getAmount());
                    st.setInt(2, dto.getSenaccno());
                    st.setInt(3, dto.getPin());
                    int update = st.executeUpdate();
                    st2.setInt(1, dto.getAmount());
                    st2.setInt(2, dto.getRecaccno());
                    int update2 = st2.executeUpdate();
                    if(update>0 && update2>0) {
                    	return 1;
                    }
                    else
                    	return 0;
        }
    }
    
    public int balance(AtmmachinDto dto) throws IOException, SQLException {
        try (Connection con = ConnectionFactory.getConnection();
             
             PreparedStatement st = con.prepareStatement("SELECT balance FROM atm WHERE accno = ? AND pin = ?")) {
          int balance;
            st.setInt(1, dto.getAccno());
            st.setInt(2, dto.getPin());

            ResultSet query = st.executeQuery();

            if (query.next()) {
                balance = query.getInt("balance"); // Retrieve balance from ResultSet
                return balance;
            }
            else
            	return -1;
        }

        
    }
	

	
}
   


