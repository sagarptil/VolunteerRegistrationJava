//VolunteerForm
package VolunteerRegistrationForm;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class VolunteerForm extends JFrame implements ActionListener {

		JLabel volunteerform,name,emailadd,phone,age,gender,address,skills,available;
		JRadioButton genm,genf,other;
		JTextField nametext,emailaddtext,phonetext,agetext,gendertext,addresstext,availabletext;
		JComboBox skillstext;
		JButton submit,clear;
		
		VolunteerForm()
		{
			setLayout(null);
			
//			Field Names
			
			volunteerform=new JLabel("Volunteer Registration Form ");
			volunteerform.setFont(new Font("railway",Font.BOLD,22));
			volunteerform.setBounds(240,80,400,30);
			add(volunteerform);
			
			name=new JLabel("Full Name : ");
			name.setFont(new Font("railway",Font.BOLD,20));
			name.setBounds(100,140,120,30);
			add(name);
			
			emailadd=new JLabel("Email :  ");
			emailadd.setFont(new Font("railway",Font.BOLD,20));
			emailadd.setBounds(100,180,180,40);
			add(emailadd);
			
			phone=new JLabel("Phone Number : ");
			phone.setFont(new Font("railway",Font.BOLD,20));
			phone.setBounds(100,220,180,50);
			add(phone);
			
			age=new JLabel("Age : ");
			age.setFont(new Font("railway",Font.BOLD,20));
			age.setBounds(100,260,180,60);
			add(age);
			
			gender=new JLabel("Gender : ");
			gender.setFont(new Font("railway",Font.BOLD,20));
			gender.setBounds(100,300,180,70);
			add(gender);
			
			address=new JLabel("Address : ");
			address.setFont(new Font("railway",Font.BOLD,20));
			address.setBounds(100,340,180,80);
			add(address);
			
			skills=new JLabel("Skill/Interest : ");
			skills.setFont(new Font("railway",Font.BOLD,20));
			skills.setBounds(100,380,180,90);
			add(skills);
			
			available=new JLabel("Availability : ");
			available.setFont(new Font("railway",Font.BOLD,20));
			available.setBounds(100,420,180,100);
			add(available);
			
			//Textfields
			
			nametext = new JTextField();
			nametext.setBounds(300,150,300,20);
			add(nametext);
			
			emailaddtext = new JTextField();
			emailaddtext.setBounds(300,190,300,20);
			add(emailaddtext);
			
			phonetext = new JTextField();
			phonetext.setBounds(300,240,300,20);
			add(phonetext);
			
			agetext = new JTextField();
			agetext.setBounds(300,280,300,20);
			add(agetext);
			
			
			addresstext = new JTextField();
			addresstext.setBounds(300,370,300,20);
			add(addresstext);
			
			String skill[]= {"Teaching","Fundraising","Full Stack Developer"};
			skillstext = new JComboBox(skill);
			skillstext.setBounds(300,415,300,20);
			add(skillstext);
			
			availabletext = new JTextField();
			availabletext.setBounds(300,465,300,20);
			add(availabletext);
			
			genm = new JRadioButton("Male");
			genm.setBounds(300,320,100,20);
			add(genm);
			
			genf = new JRadioButton("FeMale");
			genf.setBounds(400,320,100,20);
			add(genf);
			
			other = new JRadioButton("Other");
			other.setBounds(500,320,100,20);
			add(other);
			
			ButtonGroup b = new ButtonGroup();
			b.add(genm);
			b.add(genf);
			b.add(other);
			
			submit=new JButton("Submit");
			submit.setBounds(500,550,100,20);
			submit.setBackground(Color.BLACK);
			submit.setForeground(Color.WHITE);
			submit.addActionListener(this);
			add(submit);
			
			clear=new JButton("Clear");
			clear.setBounds(300,550,100,20);
			clear.setBackground(Color.BLACK);
			clear.setForeground(Color.WHITE);
			clear.addActionListener(this);
			add(clear);
			
			getContentPane().setBackground(Color.WHITE);
			setVisible(true);
			setSize(850,800);
			setLocation(350,10);

		}
		public void actionPerformed(ActionEvent e)
		{
			String name=nametext.getText();
			String emailadd=emailaddtext.getText();
			String phone=phonetext.getText();
			String age=agetext.getText();
			String gender=null;
			if(genm.isSelected())
			{
				gender="Male";
			}
			else if(genf.isSelected())
			{
				gender="Female";
			}
			String address=addresstext.getText();
			String skills=(String)skillstext.getSelectedItem();
			String available=availabletext.getText();
			try
			{
				if(name.equals(""))
				{
					JOptionPane.showMessageDialog(null, "name is required");
					
				}
				else if(e.getSource()==submit)
				{
					JOptionPane.showMessageDialog(null,"Submited Successfully");
					
					Conn c=new Conn();
					String query="insert into volunteerform values('"+name+"','"+emailadd+"','"+phone+"','"+age+"','"+gender+"','"+address+"','"+skills+"','"+available+"')";
					c.s.executeUpdate(query);
					
				}
			}
			catch(Exception ae)
			{
				System.out.println(ae);
			}
			if(e.getSource()==clear)
			{
				nametext.setText("");
				emailaddtext.setText("");
				phonetext.setText("");
				agetext.setText("");
				addresstext.setText("");
				availabletext.setText("");
			}
			
		}

		public static void main(String[] args) {
			new VolunteerForm();

		}

	}
