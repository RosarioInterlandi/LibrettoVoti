package it.polito.tdp.libretto.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.libretto.model.Voto;

public class VotoDAO {

	public List<Voto> listaVoti() {
		try {
			Connection conn = DBConnect.getConnection();
			Statement st = conn.createStatement();

			String sql = "SELECT corso, voto, dataEsame " + "FROM voto";

			ResultSet rs = st.executeQuery(sql);
			List<Voto> voti = new ArrayList<Voto>();

			while (rs.next()) {
				String corso = rs.getString("corso");
				int voto = rs.getInt("voto");
				LocalDate date = rs.getDate("dataEsame").toLocalDate();

				Voto vote = new Voto(corso, voto, date);
				voti.add(vote);
			}
			conn.close();
			return voti;

		} catch (SQLException e) {
			return null;
		}
		
		

	}

	public void creareVoto(Voto v) {
		String sql =  "INSERT INTO voto (`corso`, `voto`, `dataEsame`) VALUES (?, ?, ?);";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1,v.getCorso());
			pst.setInt(2, v.getVoto());
		//	pst.setDate(3, null);
			
			pst.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
