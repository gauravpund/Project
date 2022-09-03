import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
class Demo3 implements ActionListener
{
    JFrame frame=new JFrame("JDBC DEMO");
    Container con=frame.getContentPane();
    JLabel Imainhead,Iname,Iemail,Imobile,Igender,Idob,Ipassword,Iregis,Isearch,Idelete;
    JTextField tname,temail,tmobile,tsearch,tdelete;
    JPasswordField pass;
    JRadioButton r1,r2;
    ButtonGroup gender=new ButtonGroup();
    JComboBox day,month,year;
    JCheckBox term;
    JButton submit,reset,showall,search,delete;
    JTextArea display;
    Demo3()
    {
        frame.setBounds(150,90,1000,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        con.setLayout(null);
		
        con.setBackground(Color.cyan);
        Font f=new Font("Times New Roman",Font.BOLD,30);
        Imainhead=new JLabel("Registration Form");
        Imainhead.setForeground(Color.red);
        Imainhead.setBounds(395,5,400,35);
        Imainhead.setFont(f);
        con.add(Imainhead);

        Iname=new JLabel("First Name :");
        Iname.setForeground(Color.blue);
        Iname.setBounds(50,50,70,30);
        con.add(Iname);

        Iemail=new JLabel("Email :");
        Iemail.setForeground(Color.blue);
        Iemail.setBounds(50,250,70,30);
        con.add(Iemail);

        Imobile=new JLabel("Mobile No :");
        Imobile.setForeground(Color.blue);
        Imobile.setBounds(50,200,70,30);
        con.add(Imobile);

        Igender=new JLabel("Gender :");
        Igender.setForeground(Color.blue);
        Igender.setBounds(50,100,70,30);
        con.add(Igender);

        Idob=new JLabel("DOB :");
        Idob.setForeground(Color.blue);
        Idob.setBounds(50,150,70,30);
        con.add(Idob);

        Ipassword=new JLabel("Password :");
        Ipassword.setForeground(Color.blue);
        Ipassword.setBounds(50,300,70,30);
        con.add(Ipassword);

        tname=new JTextField();
        tname.setForeground(Color.blue);
        tname.setBounds(130,53,180,20);
        con.add(tname);

        r1=new JRadioButton("Male");
        r1.setForeground(Color.black);
        r1.setBounds(130,103,80,30);
        r1.setBackground(Color.white);
        con.add(r1);

        r2=new JRadioButton("Female");
        r2.setForeground(Color.black);
        r2.setBounds(230,103,80,30);
        r2.setBackground(Color.white);
        con.add(r2);

        gender.add(r1);
        gender.add(r2);

        temail=new JTextField();
        temail.setForeground(Color.blue);
        temail.setBounds(130,253,180,20);
        con.add(temail);

        tmobile=new JTextField();
        tmobile.setForeground(Color.blue);
        tmobile.setBounds(130,203,180,20);
        con.add(tmobile);

        pass=new JPasswordField();
        pass.setForeground(Color.blue);
        pass.setBounds(130,303,180,20);
        con.add(pass);

        String[] daylist=new String[31];
        for(int i=1;i<=31;i++)
        {
            daylist[i-1]=Integer.toString(i);
        }
        day=new JComboBox(daylist);
        day.setBounds(130,153,40,25);
        day.setEditable(true);
        day.setBackground(Color.green);
        con.add(day);

        String[] monthlist={"jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        month=new JComboBox(monthlist);
        month.setBounds(185,153,50,25);
        month.setEditable(true);
        month.setBackground(Color.green);
        con.add(month);

        String[] yearlist=new String[100];
        for(int i=1951;i<=2022;i++)
        {
            yearlist[i-1951]=Integer.toString(i);
        }
        year=new JComboBox(yearlist);
        year.setBounds(250,153,60,25);
        year.setEditable(true);
        con.add(year);

        term=new JCheckBox("I accept the terms and conditions");
        term.setBounds(70,340,250,25);
        year.setBackground(Color.green);
        year.setForeground(Color.black);

        //term.setTextColor(Color.RED);
        con.add(term);

        submit=new JButton("SUBMIT");
        submit.setForeground(Color.darkGray);
        submit.setBackground(Color.pink);
        submit.setBounds(100,380,80,25);
        con.add(submit);

        reset=new JButton("RESET");
        reset.setForeground(Color.red);
        reset.setBackground(Color.lightGray);
        reset.setBounds(200,380,80,25);
        con.add(reset);

        Iregis=new JLabel("Registration");
        Iregis.setBounds(90,420,200,50);
        Iregis.setFont(f);
        con.add(Iregis);

        Color cc=new Color(170,170,170);
        Font ff=new Font("Times New Roman",Font.BOLD,15);
        display=new JTextArea();
        display.setBounds(660,50,300,450);
        con.add(display);
        display.setFont(ff);
        display.setBackground(cc);
        display.setForeground(Color.WHITE);
        display.setEditable(false);


        showall=new JButton("SHOW DATA");
        showall.setBounds(370,80,200,30);
        con.add(showall);


        Isearch=new JLabel("Search Name");
        Isearch.setForeground(Color.blue);
        Isearch.setBounds(390,160,250,30);
        Isearch.setFont(f);

        con.add(Isearch);

        tsearch=new JTextField();
        tsearch.setBounds(370,200,200,20);
        con.add(tsearch);
        tsearch.setForeground(Color.blue);

        search=new JButton("SEARCH");
        search.setBounds(390,240,140,30);
        con.add(search);
        con.setForeground(Color.black);

        Idelete=new JLabel("Delete Name");
        Idelete.setBounds(390,320,250,30);
        Idelete.setFont(f);
        Idelete.setForeground(Color.blue);
        con.add(Idelete);

        tdelete=new JTextField();
        tdelete.setBounds(370,360,200,20);
        con.add(tdelete);

        delete=new JButton("DELETE");
        delete.setBounds(390,400,140,30);
        con.add(delete);

        submit.addActionListener(this);
        reset.addActionListener(this);
        showall.addActionListener(this);
        search.addActionListener(this);
        delete.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        String ch=e.getActionCommand();

        if(ch=="SUBMIT")
        {
            if(term.isSelected())
            {
                String name=tname.getText();
                String email=temail.getText();
                String mobile=tmobile.getText();
                String password=pass.getText();
                String gen="Male";
                if(r2.isSelected())
                {
                    gen="Female";
                }
                String date=(String)day.getSelectedItem();
                String mon=(String)month.getSelectedItem();
                String yr=(String)year.getSelectedItem();

                try
                {
                    try
                    {
                        Class.forName("org.postgresql.Driver");
                    }
                    catch(ClassNotFoundException ce)
                    {
                        display.setText("Loading Driver failed");
                    }
                    Connection conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/employe","postgres","root");

                    String sql="insert into data (name,gender,day,month,year,mobile,email,pass)values(?,?,?,?,?,?,?,?)";

                    PreparedStatement st=conn.prepareStatement(sql);

                    if(name=="Submit")
                    {
                        display.setText("Yes");
                    }

                    st.setString(1,name);
                    st.setString(2,gen);
                    st.setString(3,date);
                    st.setString(4,mon);
                    st.setString(5,yr);
                    st.setString(6,mobile);
                    st.setString(7,email);
                    st.setString(8,password);

                    st.executeUpdate();

                    JOptionPane.showMessageDialog(null,"Registration Successful");
                    conn.close();
                    st.close();
                }

                catch(Exception ae)
                {
                    JOptionPane.showMessageDialog(null,"Something went wrong");
                }

            }
            else
            {
                JOptionPane.showMessageDialog(null,"Please Fill All The Fields And/Or Agree Terms and Conditions");
            }

        }
        else
        if(ch=="SHOW DATA")
        {

            try
            {
                try
                {
                    Class.forName("org.postgresql.Driver");
                }
                catch(ClassNotFoundException ce)
                {
                    display.setText("Loading Driver failed");
                }


                Connection conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/employe","postgres","root");
                String sql = "select * from data";
                Statement st=conn.createStatement();

                ResultSet rs=st.executeQuery(sql);


                while(rs.next())
                {
                    String name=rs.getString("name");
                    String gen=rs.getString("gender");
                    String date=rs.getString("day");
                    String mon=rs.getString("month");
                    String yr=rs.getString("year");
                    String mobile=rs.getString("mobile");
                    String email=rs.getString("email");
                    String password=rs.getString("pass");
                    System.out.println();

                    display.setText("\n\nName: "+name+"\nEmail: "+email+"\nMobile No: "+mobile+"\nDate of Birth: "+date+""+mon+""+yr+"\nGender: "+gen+"\nPassword: "+password+"\n");
                }

            }
            catch(Exception ae)
            {
                JOptionPane.showMessageDialog(null,"Something went wrong...");
            }
        }
        else
        if(ch=="SEARCH")
        {
            try
            {
                try
                {
                    Class.forName("org.postgresql.Driver");
                }
                catch(ClassNotFoundException ce)
                {
                    display.setText("Loading Driver failed");
                }
                Connection conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/employe","postgres","root");

                String s1=tsearch.getText();

                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery("select * from data where name='"+s1+"'");



                while(rs.next())
                {
                    String name=rs.getString("name");
                    String gen=rs.getString("gender");
                    String date=rs.getString("day");
                    String mon=rs.getString("month");
                    String yr=rs.getString("year");
                    String mobile=rs.getString("mobile");
                    String email=rs.getString("email");
                    String password=rs.getString("pass");

                    display.setText("\n\nName: "+name+"\nEmail: "+email+"\nMobile No: "+mobile+"\nDate of Birth: "+date+""+mon+""+yr+"\nGender: "+gen+"\nPassword: "+password+"\n");

                }
            }
            catch(Exception ae)
            {
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
        }

        else
        if(ch=="DELETE")
        {
            try
            {
                try
                {
                    Class.forName("org.postgresql.Driver");
                }
                catch(ClassNotFoundException ce)
                {
                    display.setText("Loading Driver failed");
                }
                Connection conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/employe","postgres","root");

                String sql = "delete from data where name=?";

                PreparedStatement st=conn.prepareStatement(sql);

                String s1=tdelete.getText();

                st.setString(1,s1);

                st.executeUpdate();

                JOptionPane.showMessageDialog(null,"Deleted Successfully");

            }
            catch(Exception ae)
            {
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
        }
        else
        {
            tname.setText(null);
            temail.setText(null);
            tmobile.setText(null);
            pass.setText(null);
            tsearch.setText(null);
            tdelete.setText(null);
            display.setText(null);

            gender.clearSelection();
            term.setSelected(false);
            day.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
        }
    }
}
class DummyJDBC
{
    public static void main(String args[])
    {
        Demo3 j=new Demo3();
    }
}