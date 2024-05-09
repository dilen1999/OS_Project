//import java.awt.Component;
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.DataOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.net.Socket;
//
//import javax.swing.BoxLayout;
//import javax.swing.JButton;
//import javax.swing.JFileChooser;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//
//public class Client {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		final File[] fileToSend = new File[1];
//		
//		JFrame jFrame = new JFrame("WittCode's Client");
//		jFrame.setSize(450,450);
//		jFrame.setLayout(new BoxLayout(jFrame.getContentPane(),BoxLayout.Y_AXIS));
//		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
//		
//		JLabel jlTitle = new JLabel("wittCode's File Sender");
//		jlTitle.setFont(new Font("Arial", Font.BOLD,25));
//		jlTitle.setBorder(new EmptyBorder(20, 0, 10, 0));
//		jlTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
//		
//		JLabel jlFileName = new JLabel("Choose a file to send");
//		jlFileName.setFont(new Font("Arial", Font.BOLD,25));
//		jlFileName.setBorder(new EmptyBorder(50, 0, 10, 0));
//		jlFileName.setAlignmentX(Component.CENTER_ALIGNMENT);
//		
//		JPanel jpButton = new JPanel(); 
//		jpButton.setBorder(new EmptyBorder(75,0,10,0));
//		
//		JButton jbSendFile = new JButton("Send File");
//		jbSendFile.setPreferredSize(new Dimension(150, 75));
//		jbSendFile.setFont(new Font("Arial", Font.BOLD,20));
//		
//		JButton jbChooseFile = new JButton("Choose File");
//		jbChooseFile.setPreferredSize(new Dimension(150, 75));
//		jbChooseFile.setFont(new Font("Arial", Font.BOLD,20));
//		
//		jpButton.add(jbSendFile);
//		jpButton.add(jbChooseFile);
//		
//		jbChooseFile.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JFileChooser jFileChooser = new JFileChooser();
//				jFileChooser.setDialogTitle("Choose a file to send");
//				
//				if(jFileChooser.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) {
//					fileToSend[0] = jFileChooser.getSelectedFile();
//					jlFileName.setText("The file you want to send is: "+ fileToSend[0].getName());
//				}
//			}
//		});
//		
//		jbSendFile.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(fileToSend[0]==null) {
//					jlFileName.setText("Plese choose a file first");
//				} else {
//					try {
//					FileInputStream fileInputStream = new FileInputStream(fileToSend[0].getAbsolutePath());
//					Socket socket = new Socket("localhost", 1234);
//					
//					DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
//					
//					String fileName = fileToSend[0].getName();
//					byte[] fileNameBytes = fileName.getBytes();
//					
//					byte[] fileContentBytes = new byte[(int)fileToSend[0].length()];
//					fileInputStream.read(fileContentBytes);
//					
//					dataOutputStream.writeInt(fileNameBytes.length);
//					dataOutputStream.write(fileNameBytes);
//					
//					dataOutputStream.writeInt(fileContentBytes.length);
//					dataOutputStream.write(fileContentBytes);
//					} catch(IOException error) {
//						error.printStackTrace();
//					}
//					
//				}
//			}
//		});
//		
//		jFrame.add(jlTitle);
//		jFrame.add(jlFileName);
//		jFrame.add(jpButton);
//		jFrame.setVisible(true);
//		
//
//	}
//
//}


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        // Accessed from within inner class needs to be final or effectively final.
        final File[] fileToSend = new File[1];

        // Set the frame to house everything.
        JFrame jFrame = new JFrame("File Sharing Syatem");
        // Set the size of the frame.
        jFrame.setSize(500, 500);
        // Make the layout to be box layout that places its children on top of each other.
        jFrame.setLayout(new BoxLayout(jFrame.getContentPane(), BoxLayout.Y_AXIS));
        // Make it so when the frame is closed the program exits successfully.
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Title above panel.
        JLabel jlTitle = new JLabel("FILE SHARING SYSTEM");
        // Change the font family, size, and style.
        jlTitle.setFont(new Font("Arial", Font.BOLD, 30));
        // Add a border around the label for spacing.
        jlTitle.setBorder(new EmptyBorder(20,0,10,0));
        // Make it so the title is centered horizontally.
        jlTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

     // Set custom colors and font for the title label
        jlTitle.setForeground(Color.BLUE); // Example text color: Blue
        jlTitle.setFont(new Font("Arial", Font.BOLD, 30)); // Example font: Arial, Bold, Size 30



        // Add shadow effect using JLabel's shadow properties
     // Set the text color of the label
        jlTitle.setForeground(Color.BLACK); // Main text color: Blue

        jlTitle.setOpaque(false); // Make the label transparent
       

        // Make it so the title is centered horizontally.
        jlTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

     // Label that has the file name.
        JLabel jlFileName = new JLabel("Choose a file to send.");
        // Change the font.
        jlFileName.setFont(new Font("Arial", Font.BOLD, 20));
        // Make a border for spacing.
        jlFileName.setBorder(new EmptyBorder(100, 0, 0, 0));
        // Center the label on the x axis (horizontally).
        jlFileName.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Set text color for the label
        jlFileName.setForeground(Color.RED); // Change text color to red

        // Set custom colors and font for the file name label
        jlFileName.setForeground(Color.BLACK); // Example text color: Black
        jlFileName.setFont(new Font("Arial", Font.BOLD, 20)); // Example font: Arial, Bold, Size 20

        // Add a border for spacing and decoration
        jlFileName.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Example empty border: 20px top/bottom, 0px left/right

        // Add shadow effect using JLabel's shadow properties
        jlFileName.setForeground(new Color(70, 130, 180)); // Text color: Steel Blue (Example)
        jlFileName.setOpaque(false); // Make the label transparent

        // Center the label on the x-axis (horizontally).
        jlFileName.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Panel that contains the buttons.
        JPanel jpButton = new JPanel();
     // Set the layout manager to BoxLayout with vertical alignment
        jpButton.setLayout(new BoxLayout(jpButton, BoxLayout.Y_AXIS));
        // Border for panel that houses buttons.
        jpButton.setBorder(new EmptyBorder(5, 0, 5, 0));

        
        
        // Make the second button to choose a file.
        JButton jbChooseFile = new JButton("<html>Choose File<br>\\u25BC</html>");
        // Set the size which must be preferred size for within a container.
     //   jbChooseFile.setPreferredSize(new Dimension(500, 400));
        jbChooseFile.setPreferredSize(new Dimension(500, 200));
    //    jbChooseFile.setMaximumSize(new Dimension(Short.MAX_VALUE, jbChooseFile.getPreferredSize().height));
        jbChooseFile.setMaximumSize(new Dimension(Integer.MAX_VALUE, jbChooseFile.getPreferredSize().height));
        // Set the font for the button.
        jbChooseFile.setFont(new Font("Arial", Font.BOLD, 30));
        
       
        // Border for panel that houses buttons.
        jpButton.setBorder(new EmptyBorder(5, 0, 5, 0));
     // Center the button horizontally.
        jbChooseFile.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Create send file button.
        JButton jbSendFile = new JButton("Send File");
        // Set preferred size works for layout containers.
        jbSendFile.setPreferredSize(new Dimension(150, 50));
        // Change the font style, type, and size for the button.
        jbSendFile.setFont(new Font("Arial", Font.BOLD, 20));

     // Create a compound border with a dotted line inside and an empty border outside
        Border dottedBorder = BorderFactory.createCompoundBorder(
                new LineBorder(Color.BLACK, 1, true), // Line border with 1px thickness, dotted style
                new EmptyBorder(5, 5, 5, 5) // Empty border with 5px insets
        );
     // Apply the compound border to the "Choose File" button
        jbChooseFile.setBorder(dottedBorder);
       // jbSendFile.setBorder(new EmptyBorder(10, 20, 10, 20)); // Example empty border: 10px top/bottom, 20px left/right
     // Center the button horizontally.
        jbSendFile.setAlignmentX(Component.CENTER_ALIGNMENT);
        

        // Border for panel that houses buttons.
        jpButton.setBorder(new EmptyBorder(5, 0, 10, 0));
        // Add the buttons to the panel.
        
      
        jpButton.add(jbChooseFile);
        // Border for panel that houses buttons.
        jpButton.setBorder(new EmptyBorder(50, 0, 10, 0));
        jpButton.add(jbSendFile);

     // Set custom colors for buttons
        jbSendFile.setBackground(new Color(0, 102, 204)); // Example color: Blue
        jbChooseFile.setBackground(new Color(255, 255, 255)); // Example color: Green
        jbSendFile.setForeground(Color.WHITE); // Text color
        jbChooseFile.setForeground(Color.BLACK); // Text color


        // Set font for buttons
        Font buttonFont = new Font("Arial", Font.BOLD, 16); // Example font
        jbSendFile.setFont(buttonFont);
        jbChooseFile.setFont(buttonFont);

        // Apply hover effect (change background color on hover)
        jbSendFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbSendFile.setBackground(new Color(41, 128, 185)); // Example hover color: Darker blue
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbSendFile.setBackground(new Color(52, 152, 219)); // Original color
            }
        });

        jbChooseFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbChooseFile.setBackground(new Color(204, 229, 255)); // Example hover color: Darker green
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbChooseFile.setBackground(new Color(255, 255, 255)); // Original color
            }
        });

        // Button action for choosing the file.
        // This is an inner class so we need the fileToSend to be final.
     // Button action for choosing the file.
     // This is an inner class so we need the fileToSend to be final.
     jbChooseFile.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             // Create a file chooser to open the dialog to choose a file.
             JFileChooser jFileChooser = new JFileChooser();
             // Set the title of the dialog.
             jFileChooser.setDialogTitle("Choose a file to send.");
             // Show the dialog and if a file is chosen from the file chooser execute the following statements.
             if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                 // Get the selected file.
                 fileToSend[0] = jFileChooser.getSelectedFile();
                 // Change the text of the java swing label to have the file name.
                 jlFileName.setText("The file you want to send is: " + fileToSend[0].getName());
             }
         }
     });

     // Start blinking animation for Choose File button
     Timer timer = new Timer(500, new ActionListener() {
         boolean isTextVisible = true;

         @Override
         public void actionPerformed(ActionEvent e) {
             jbChooseFile.setText(isTextVisible ? "Choose File" : "");
             isTextVisible = !isTextVisible;
         }
     });
     timer.start();

     // Stop blinking animation when Send File button is clicked
     jbSendFile.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             // Stop the blinking animation
             timer.stop();

             if (fileToSend[0] == null) {
                 jlFileName.setText("Please choose a file to send first!");
             } else {
                 try {
                     // Create an input stream into the file you want to send.
                     FileInputStream fileInputStream = new FileInputStream(fileToSend[0].getAbsolutePath());
                     // Create a socket connection to connect with the server.
                     Socket socket = new Socket("localhost", 1234);
                     // Create an output stream to write to write to the server over the socket connection.
                     DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                     // Get the name of the file you want to send and store it in filename.
                     String fileName = fileToSend[0].getName();
                     // Convert the name of the file into an array of bytes to be sent to the server.
                     byte[] fileNameBytes = fileName.getBytes();
                     // Create a byte array the size of the file so don't send too little or too much data to the server.
                     byte[] fileBytes = new byte[(int) fileToSend[0].length()];
                     // Put the contents of the file into the array of bytes to be sent so these bytes can be sent to the server.
                     fileInputStream.read(fileBytes);
                     // Send the length of the name of the file so server knows when to stop reading.
                     dataOutputStream.writeInt(fileNameBytes.length);
                     // Send the file name.
                     dataOutputStream.write(fileNameBytes);
                     // Send the length of the byte array so the server knows when to stop reading.
                     dataOutputStream.writeInt(fileBytes.length);
                     // Send the actual file.
                     dataOutputStream.write(fileBytes);
                 } catch (IOException ex) {
                     ex.printStackTrace();
                 }
             }
         }
     });


 
        // Add everything to the frame and make it visible.
        jFrame.add(jlTitle);
        jFrame.add(jlFileName);
        jFrame.add(jpButton);
        jFrame.setVisible(true);
    }

}
