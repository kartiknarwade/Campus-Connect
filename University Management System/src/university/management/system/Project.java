package university.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project extends JFrame implements ActionListener {

    Project() {
        super("University Management System");

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Background Image
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/third.jpg"));
        Image i3 = ic.getImage().getScaledInstance(
                Toolkit.getDefaultToolkit().getScreenSize().width,
                Toolkit.getDefaultToolkit().getScreenSize().height,
                Image.SCALE_SMOOTH);
        JLabel l1 = new JLabel(new ImageIcon(i3));
        add(l1);

        // ===== Bigger Font for Menus and MenuItems =====
        Font menuFont = new Font("SansSerif", Font.BOLD, 20);
        UIManager.put("Menu.font", menuFont);
        UIManager.put("MenuItem.font", menuFont);

        JMenuBar mb = new JMenuBar();

        // MASTER
        JMenu master = new JMenu("Master");
        master.setForeground(Color.BLUE);
        JMenuItem m1 = new JMenuItem("New Faculty");
        JMenuItem m2 = new JMenuItem("New Student Admission");
        m1.setBackground(Color.WHITE);
        m2.setBackground(Color.WHITE);
        m1.addActionListener(this);
        m2.addActionListener(this);
        master.add(m1);
        master.add(m2);

        // DETAILS
        JMenu user = new JMenu("Details");
        user.setForeground(Color.RED);
        JMenuItem u1 = new JMenuItem("Student Details");
        JMenuItem u2 = new JMenuItem("Teacher Details");
        u1.setBackground(Color.WHITE);
        u2.setBackground(Color.WHITE);
        u1.addActionListener(this);
        u2.addActionListener(this);
        user.add(u1);
        user.add(u2);

        // ATTENDANCE
        JMenu attendance = new JMenu("Attendance");
        attendance.setForeground(Color.BLUE);
        JMenuItem a1 = new JMenuItem("Student Attendance");
        JMenuItem a2 = new JMenuItem("Teacher Attendance");
        a1.setBackground(Color.WHITE);
        a2.setBackground(Color.WHITE);
        a1.addActionListener(this);
        a2.addActionListener(this);
        attendance.add(a1);
        attendance.add(a2);

        // ATTENDANCE DETAIL
        JMenu attendance_detail = new JMenu("Attendance Detail");
        attendance_detail.setForeground(Color.RED);
        JMenuItem b1 = new JMenuItem("Student Attendance Detail");
        JMenuItem b2 = new JMenuItem("Teacher Attendance Detail");
        b1.setBackground(Color.WHITE);
        b2.setBackground(Color.WHITE);
        b1.addActionListener(this);
        b2.addActionListener(this);
        attendance_detail.add(b1);
        attendance_detail.add(b2);

        // EXAMINATION
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        JMenuItem c1 = new JMenuItem("Examination Details");
        JMenuItem c2 = new JMenuItem("Enter Marks");
        c1.setBackground(Color.WHITE);
        c2.setBackground(Color.WHITE);
        c1.addActionListener(this);
        c2.addActionListener(this);
        exam.add(c1);
        exam.add(c2);

        // UPDATE DETAILS
        JMenu report = new JMenu("Update Details");
        report.setForeground(Color.RED);
        JMenuItem r1 = new JMenuItem("Update Students");
        JMenuItem r2 = new JMenuItem("Update Teachers");
        r1.setBackground(Color.WHITE);
        r2.setBackground(Color.WHITE);
        r1.addActionListener(this);
        r2.addActionListener(this);
        report.add(r1);
        report.add(r2);

        // FEE DETAILS
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLUE);
        JMenuItem s1 = new JMenuItem("Fee Structure");
        JMenuItem s2 = new JMenuItem("Student Fee Form");
        s1.setBackground(Color.WHITE);
        s2.setBackground(Color.WHITE);
        s1.addActionListener(this);
        s2.addActionListener(this);
        fee.add(s1);
        fee.add(s2);

        // UTILITY
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.RED);
        JMenuItem ut1 = new JMenuItem("Notepad");
        JMenuItem ut2 = new JMenuItem("Calculator");
        JMenuItem ut3 = new JMenuItem("Web Browser");
        ut1.setBackground(Color.WHITE);
        ut2.setBackground(Color.WHITE);
        ut3.setBackground(Color.WHITE);
        ut1.addActionListener(this);
        ut2.addActionListener(this);
        ut3.addActionListener(this);
        utility.add(ut1);
        utility.add(ut2);
        utility.add(ut3);

        // ABOUT
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLUE);
        JMenuItem aboutus = new JMenuItem("About Us");
        aboutus.setBackground(Color.WHITE);
        aboutus.addActionListener(this);
        about.add(aboutus);

        // EXIT
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.RED);
        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);

        // Add Menus to MenuBar
        mb.add(master);
        mb.add(user);
        mb.add(attendance);
        mb.add(attendance_detail);
        mb.add(exam);
        mb.add(report);
        mb.add(fee);
        mb.add(utility);
        mb.add(about);
        mb.add(exit);

        setJMenuBar(mb);
        setLayout(new FlowLayout());
        setVisible(false);
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("New Student Admission")) {
            new AddStudent().f.setVisible(true);
        } else if (msg.equals("New Faculty")) {
            new AddTeacher().f.setVisible(true);
        } else if (msg.equals("Student Details")) {
            new StudentDetails().setVisible(true);
        } else if (msg.equals("Teacher Details")) {
            new TeacherDetails().setVisible(true);
        } else if (msg.equals("Update Students")) {
            new UpdateStudent().f.setVisible(true);
        } else if (msg.equals("Update Teachers")) {
            new UpdateTeacher().f.setVisible(true);
        } else if (msg.equals("Fee Structure")) {
            new FeeStructure().setVisible(true);
        } else if (msg.equals("Student Fee Form")) {
            new StudentFeeForm().setVisible(true);
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) { }
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) { }
        } else if (msg.equals("Web Browser")) {
            try {
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
            } catch (Exception e) { }
        } else if (msg.equals("Exit")) {
            System.exit(0);
        } else if (msg.equals("About Us")) {
            new AboutUs().setVisible(true);
        } else if (msg.equals("Student Attendance")) {
            new StudentAttendance().setVisible(true);
        } else if (msg.equals("Teacher Attendance")) {
            new TeacherAttendance().setVisible(true);
        } else if (msg.equals("Student Attendance Detail")) {
            new StudentAttendanceDetail().setVisible(true);
        } else if (msg.equals("Teacher Attendance Detail")) {
            new TeacherAttendanceDetail().setVisible(true);
        } else if (msg.equals("Examination Details")) {
            new ExaminationDetails().setVisible(true);
        } else if (msg.equals("Enter Marks")) {
            new EnterMarks().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Project().setVisible(true);
    }
}
