package miniproject;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RootController implements Initializable {
	@FXML private Button btn1;
	@FXML private Button btn2;
	@FXML private Button btn3;
	@FXML private Button btn4;
	@FXML private Button btn5;
	@FXML private TextField tf1;
	@FXML private TextField tf2;
	@FXML private TextField tf3;
	@FXML private TextField tf4;
	@FXML private TextField tf5;
	@FXML private TextArea ta1;
	
	AssignDao ad;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ad = new AssignDao();
		try {
			ad.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		btn1.setOnAction(e->{
			try {
				handle1(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		
		btn2.setOnAction(e->{
			try {
				handle2(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		btn3.setOnAction(e->{
			try {
				handle3(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		btn4.setOnAction(e->{
			try {
				handle4(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		btn5.setOnAction(e-> {
			try {
				handle5(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		
	}
	

	private void handle1(ActionEvent e) throws Exception {
		Assign assign = new Assign(Integer.parseInt(tf1.getText()),Integer.parseInt(tf2.getText()),tf3.getText(),tf4.getText(),Integer.parseInt(tf5.getText()));
		int nn = ad.insert(assign);
		System.out.println(nn + "건 입력");
	
	}
	

	private void handle2(ActionEvent e) throws Exception {
		Assign assign = ad.getAssign(Integer.parseInt(tf1.getText()));
		tf1.setText(assign.emp_id+"");
		tf2.setText(assign.depart_id+"");
		tf3.setText(assign.first_name);
		tf4.setText(assign.last_name);
		tf5.setText(assign.salary+"");
	
	}
	
	

	private void handle3(ActionEvent e) throws SQLException {
		// TODO Auto-generated method stub
		Assign assign = new Assign(Integer.parseInt(tf1.getText()),Integer.parseInt(tf2.getText()),tf3.getText(),tf4.getText(),Integer.parseInt(tf5.getText()));
		int nn = ad.update(assign);
		System.out.println(nn + "건 수정");
	
	}

	private void handle4(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		Assign assign = new Assign(Integer.parseInt(tf1.getText()),Integer.parseInt(tf2.getText()),tf3.getText(),tf4.getText(),Integer.parseInt(tf5.getText()));
		int nn = ad.delete(assign);
		System.out.println(nn + "건 삭제");
	}

	private void handle5(ActionEvent e) throws SQLException {
		String sa = "";
		for (Assign assign : ad.lists()) {
			sa = sa + String.format("%d, %d, %s, %s, %d\n", assign.emp_id, assign.depart_id, assign.first_name, assign.last_name, assign.salary);
		ta1.setText(sa);
		}
	}



}
