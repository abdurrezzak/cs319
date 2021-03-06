/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projket;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
/**
 *
 * @author abdurrezzak
 */
public class Albums extends javax.swing.JFrame {

    
    
    User curUser = new User();
    String curusername="";
    Album curAlbum = new Album();
    
    public Albums() throws FileNotFoundException, IOException, ClassNotFoundException {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        jPanel1.setBackground(new Color(82,3,68,0));
        propicLabel.setToolTipText("Click here to change your profile picture!");
        creatingAlbumFrame.setVisible(false);
        creatingAlbumFrame.setBackground(new Color(82,3,68));
        albumBcg.setBackground(new Color(82,3,68));
        oldAlbumsList.setBackground(Color.BLACK);
        anAlbumFrame.setVisible(false);
        anAlbumFrame.setBackground(new Color(82,3,68));
        /*
            this part figures out who logged in
        */
        String line = null; 
        FileReader fileReader = new FileReader("sessions/usernames.txt");
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while((line = bufferedReader.readLine()) != null) {
                curusername = line;
            }
        } 
        
        /*
            this part gets the info about the current user
        */
        
        FileInputStream fis = new FileInputStream("users/"+curusername+".ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        curUser = (User) ois.readObject();
        
        //getting current info
        propicLabel.setIcon(new ImageIcon(new ImageIcon(curUser.getProfilePicture()).getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH)));
        usernameLabel.setText("Welcome "+curUser.getUsername() + "!");
        
        DefaultListModel dm = new DefaultListModel();
        
        for(int i=0;i<curUser.getAlbums().size();i++)
        {
            dm.addElement(curUser.getAlbums().get(i).getname());
        }
        
        oldAlbumsList.setModel(dm);
        
        
        
        
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        creatingAlbumFrame = new javax.swing.JPanel();
        finishCreation = new javax.swing.JButton();
        addedImages = new javax.swing.JPanel();
        albumTit = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        addImage = new javax.swing.JButton();
        albumBcg = new javax.swing.JLabel();
        anAlbumFrame = new javax.swing.JPanel();
        Photos = new javax.swing.JPanel();
        anAlbumTitle = new javax.swing.JLabel();
        deleteAlbum = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        oldAlbumsList = new javax.swing.JList<>();
        createAlbum = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        nyxBut = new javax.swing.JButton();
        newEntryBut = new javax.swing.JButton();
        yourDaysBut = new javax.swing.JButton();
        propicLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        notesBut = new javax.swing.JButton();
        oldEntriesBut = new javax.swing.JButton();
        albumsBut = new javax.swing.JButton();
        oldTalksBut = new javax.swing.JButton();
        exitBut = new javax.swing.JLabel();
        settingsBut = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        bcghomelabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 1280, 670));
        setMinimumSize(new java.awt.Dimension(1280, 670));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        creatingAlbumFrame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        finishCreation.setText("Create");
        finishCreation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                finishCreationMouseClicked(evt);
            }
        });
        creatingAlbumFrame.add(finishCreation, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 380, 180, 90));

        addedImages.setLayout(new java.awt.GridLayout(1, 0));
        creatingAlbumFrame.add(addedImages, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 580, 310));
        creatingAlbumFrame.add(albumTit, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 570, 50));
        creatingAlbumFrame.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 570, 20));

        addImage.setText("Add Image");
        addImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addImageMouseClicked(evt);
            }
        });
        creatingAlbumFrame.add(addImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 180, 240));
        creatingAlbumFrame.add(albumBcg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 500));

        getContentPane().add(creatingAlbumFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 850, 500));

        anAlbumFrame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anAlbumFrameMouseClicked(evt);
            }
        });
        anAlbumFrame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Photos.setLayout(new java.awt.GridLayout(2, 7));
        anAlbumFrame.add(Photos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 1050, 360));

        anAlbumTitle.setFont(new java.awt.Font("Ubuntu", 2, 36)); // NOI18N
        anAlbumTitle.setForeground(new java.awt.Color(243, 92, 239));
        anAlbumFrame.add(anAlbumTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 15, 1050, 70));

        deleteAlbum.setText("Delete Album");
        deleteAlbum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteAlbumMouseClicked(evt);
            }
        });
        anAlbumFrame.add(deleteAlbum, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 510, 200, -1));

        getContentPane().add(anAlbumFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 1150, 550));

        oldAlbumsList.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        oldAlbumsList.setForeground(new java.awt.Color(162, 78, 162));
        oldAlbumsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        oldAlbumsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                oldAlbumsListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(oldAlbumsList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 810, 410));

        createAlbum.setText("Create Album");
        createAlbum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createAlbumMouseClicked(evt);
            }
        });
        getContentPane().add(createAlbum, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 580, 810, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projket/rsz_2logo.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 240, 100));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 210));
        jLabel1.setText("Albums");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 450, 50));

        jPanel1.setBackground(new java.awt.Color(82, 3, 68));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nyxBut.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        nyxBut.setForeground(new java.awt.Color(1, 1, 1));
        nyxBut.setText("TALK TO NYX");
        nyxBut.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        nyxBut.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        nyxBut.setMargin(new java.awt.Insets(0, 100, 0, 0));
        nyxBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nyxButMouseClicked(evt);
            }
        });
        nyxBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nyxButActionPerformed(evt);
            }
        });
        jPanel1.add(nyxBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 260, 40));

        newEntryBut.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        newEntryBut.setForeground(new java.awt.Color(1, 1, 1));
        newEntryBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projket/addentry.png"))); // NOI18N
        newEntryBut.setText("New Entry");
        newEntryBut.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        newEntryBut.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        newEntryBut.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        newEntryBut.setMargin(new java.awt.Insets(0, 100, 0, 0));
        newEntryBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newEntryButMouseClicked(evt);
            }
        });
        newEntryBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEntryButActionPerformed(evt);
            }
        });
        jPanel1.add(newEntryBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 120, 40));

        yourDaysBut.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        yourDaysBut.setForeground(new java.awt.Color(1, 1, 1));
        yourDaysBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projket/yourdays.png"))); // NOI18N
        yourDaysBut.setText("Your Days");
        yourDaysBut.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        yourDaysBut.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        yourDaysBut.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        yourDaysBut.setMargin(new java.awt.Insets(0, 100, 0, 0));
        yourDaysBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yourDaysButMouseClicked(evt);
            }
        });
        yourDaysBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourDaysButActionPerformed(evt);
            }
        });
        jPanel1.add(yourDaysBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 120, 40));

        propicLabel.setBackground(new java.awt.Color(221, 128, 35));
        propicLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        propicLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                propicLabelMouseClicked(evt);
            }
        });
        jPanel1.add(propicLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 200, 150));

        usernameLabel.setFont(new java.awt.Font("Symbola", 2, 24)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(254, 254, 254));
        jPanel1.add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 220, 40));

        notesBut.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        notesBut.setForeground(new java.awt.Color(1, 1, 1));
        notesBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projket/notes.png"))); // NOI18N
        notesBut.setText("Notes");
        notesBut.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        notesBut.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        notesBut.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        notesBut.setMargin(new java.awt.Insets(0, 100, 0, 0));
        notesBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notesButMouseClicked(evt);
            }
        });
        notesBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notesButActionPerformed(evt);
            }
        });
        jPanel1.add(notesBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 120, 40));

        oldEntriesBut.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        oldEntriesBut.setForeground(new java.awt.Color(1, 1, 1));
        oldEntriesBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projket/oldentries.png"))); // NOI18N
        oldEntriesBut.setText("Old Entries");
        oldEntriesBut.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        oldEntriesBut.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        oldEntriesBut.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        oldEntriesBut.setMargin(new java.awt.Insets(0, 100, 0, 0));
        oldEntriesBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oldEntriesButMouseClicked(evt);
            }
        });
        oldEntriesBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldEntriesButActionPerformed(evt);
            }
        });
        jPanel1.add(oldEntriesBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 120, 40));

        albumsBut.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        albumsBut.setForeground(new java.awt.Color(1, 1, 1));
        albumsBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projket/albums.png"))); // NOI18N
        albumsBut.setText("Albums");
        albumsBut.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        albumsBut.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        albumsBut.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        albumsBut.setMargin(new java.awt.Insets(0, 100, 0, 0));
        albumsBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                albumsButMouseClicked(evt);
            }
        });
        albumsBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                albumsButActionPerformed(evt);
            }
        });
        jPanel1.add(albumsBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 120, 40));

        oldTalksBut.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        oldTalksBut.setForeground(new java.awt.Color(1, 1, 1));
        oldTalksBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projket/oldtalks.png"))); // NOI18N
        oldTalksBut.setText("Old Talks");
        oldTalksBut.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        oldTalksBut.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        oldTalksBut.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        oldTalksBut.setMargin(new java.awt.Insets(0, 100, 0, 0));
        oldTalksBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oldTalksButMouseClicked(evt);
            }
        });
        oldTalksBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldTalksButActionPerformed(evt);
            }
        });
        jPanel1.add(oldTalksBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 120, 40));

        exitBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projket/exitt.png"))); // NOI18N
        exitBut.setText("jLabel3");
        exitBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButMouseClicked(evt);
            }
        });
        jPanel1.add(exitBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 50, 50));

        settingsBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projket/settings.png"))); // NOI18N
        settingsBut.setText("jLabel3");
        settingsBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingsButMouseClicked(evt);
            }
        });
        jPanel1.add(settingsBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 50, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 290, 520));

        jSeparator1.setBackground(new java.awt.Color(203, 218, 64));
        jSeparator1.setForeground(new java.awt.Color(164, 238, 51));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 30, 470));

        bcghomelabel.setBackground(new java.awt.Color(82, 3, 68));
        bcghomelabel.setForeground(new java.awt.Color(254, 254, 254));
        bcghomelabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projket/bcghome.jpg"))); // NOI18N
        bcghomelabel.setText("ASDASADASDASDASDSA");
        bcghomelabel.setOpaque(true);
        getContentPane().add(bcghomelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nyxButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nyxButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nyxButActionPerformed

    private void newEntryButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEntryButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newEntryButActionPerformed

    private void yourDaysButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourDaysButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yourDaysButActionPerformed

    private void propicLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_propicLabelMouseClicked
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        
        propicLabel.setIcon(new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH)));
        //ImageIcon icon=new ImageIcon(filename);
        //jLabel3.setIcon(icon);
        
    }//GEN-LAST:event_propicLabelMouseClicked

    private void notesButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notesButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notesButActionPerformed

    private void oldEntriesButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldEntriesButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oldEntriesButActionPerformed

    private void albumsButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_albumsButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_albumsButActionPerformed

    private void oldTalksButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldTalksButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oldTalksButActionPerformed

    private void exitButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_exitButMouseClicked

    private void settingsButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsButMouseClicked
        this.setVisible(false);
        try {
            new Settings().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Albums.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Albums.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_settingsButMouseClicked

    private void newEntryButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newEntryButMouseClicked
        
        this.setVisible(false);
        try {
            new NewEntry().setVisible(true);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Albums.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_newEntryButMouseClicked

    private void notesButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notesButMouseClicked
        this.setVisible(false);
        try {
            new Notes().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Albums.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Albums.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }//GEN-LAST:event_notesButMouseClicked

    private void yourDaysButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yourDaysButMouseClicked
        this.setVisible(false);
        try {
            new YourDays().setVisible(true);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Albums.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_yourDaysButMouseClicked

    private void oldEntriesButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oldEntriesButMouseClicked
        this.setVisible(false);
        try {
            new OldEntries().setVisible(true);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Albums.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_oldEntriesButMouseClicked

    private void oldTalksButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oldTalksButMouseClicked
        this.setVisible(false);
        try {
            new OldTalks().setVisible(true);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Albums.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_oldTalksButMouseClicked

    private void albumsButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_albumsButMouseClicked
        this.setVisible(false);
        try {
            new Albums().setVisible(true);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Albums.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_albumsButMouseClicked

    private void nyxButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nyxButMouseClicked
        this.setVisible(false);
        try {
            new Nyx().setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(Albums.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nyxButMouseClicked

    private void createAlbumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createAlbumMouseClicked
        
        creatingAlbumFrame.setVisible(true);
        oldAlbumsList.setVisible(false);
        createAlbum.setVisible(false);
    }//GEN-LAST:event_createAlbumMouseClicked

    private void addImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addImageMouseClicked
        
        addedImages.setVisible(false);
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        
        JLabel labelim = new JLabel();
        labelim.setIcon(new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(280, 280, Image.SCALE_SMOOTH)));
        
        addedImages.add(labelim);
        
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        String imgtit = df.format(dateobj);
        
        Photo p = new Photo();
        p.setTitle("image: " +imgtit );
        p.changeImage(filename);
        
        curAlbum.addNewPhoto(p);
        
        addedImages.setVisible(true);
        
        
        
    }//GEN-LAST:event_addImageMouseClicked

    private void finishCreationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finishCreationMouseClicked
        
        curAlbum.setName(albumTit.getText());
        curAlbum.date = new Date();
        
        curUser.addAlbum(curAlbum);
        
        FileOutputStream fout = null;
        File ff = new File("users/"+curUser.getUsername()+".ser");
        ff.delete();
        
        try {
            fout = new FileOutputStream("users/"+curUser.getUsername()+".ser");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Albums.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fout);
        } catch (IOException ex) {
            Logger.getLogger(Albums.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            oos.writeObject(curUser);
        } catch (IOException ex) {
            Logger.getLogger(Albums.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        creatingAlbumFrame.setVisible(false);
        this.dispose();
        
        try {
            new Albums().setVisible(true);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Albums.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }//GEN-LAST:event_finishCreationMouseClicked

    private void oldAlbumsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_oldAlbumsListValueChanged
        
        jPanel1.setVisible(false);
        oldAlbumsList.setVisible(false);
        
        try{
            
            //JOptionPane.showMessageDialog(new JFrame(), "You seem to have forgotten your password, please try again.");

            curAlbum = new Album();
            
            curAlbum.setName(oldAlbumsList.getSelectedValue());
            curAlbum = curUser.getSpecificAlbum(curAlbum);
            anAlbumTitle.setText(curAlbum.getname());
            
            
            Photos.setVisible(false);
            for (int i=0;i<curAlbum.getPhotos().size();i++) {
                JLabel nl = new JLabel();
                nl.setIcon(new ImageIcon(new ImageIcon(curAlbum.getPhotos().get(i).getImage()).getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
                
                Photos.add(nl);
                
            }
            Photos.setVisible(true);
            

            anAlbumFrame.setVisible(true);
            
        }catch(NullPointerException e)
        {
            
        }
        
        
    }//GEN-LAST:event_oldAlbumsListValueChanged

    private void anAlbumFrameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anAlbumFrameMouseClicked
        
        this.dispose();
        try {
            new Albums().setVisible(true);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Albums.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_anAlbumFrameMouseClicked

    private void deleteAlbumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteAlbumMouseClicked
        
        curUser.deleteAlbum(curAlbum);
        FileOutputStream fout = null;
        File ff = new File("users/"+curUser.getUsername()+".ser");
        ff.delete();
        try {
            fout = new FileOutputStream("users/"+curUser.getUsername()+".ser");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Notes.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fout);
        } catch (IOException ex) {
            Logger.getLogger(Notes.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            oos.writeObject(curUser);
        } catch (IOException ex) {
            Logger.getLogger(Notes.class.getName()).log(Level.SEVERE, null, ex);
        }
        anAlbumFrame.setVisible(false);
        this.dispose();
        try {
            new Albums().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Notes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Notes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_deleteAlbumMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Albums.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Albums().setVisible(true);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Albums.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Photos;
    private javax.swing.JButton addImage;
    private javax.swing.JPanel addedImages;
    private javax.swing.JLabel albumBcg;
    private javax.swing.JTextField albumTit;
    private javax.swing.JButton albumsBut;
    private javax.swing.JPanel anAlbumFrame;
    private javax.swing.JLabel anAlbumTitle;
    private javax.swing.JLabel bcghomelabel;
    private javax.swing.JButton createAlbum;
    private javax.swing.JPanel creatingAlbumFrame;
    private javax.swing.JButton deleteAlbum;
    private javax.swing.JLabel exitBut;
    private javax.swing.JButton finishCreation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton newEntryBut;
    private javax.swing.JButton notesBut;
    private javax.swing.JButton nyxBut;
    private javax.swing.JList<String> oldAlbumsList;
    private javax.swing.JButton oldEntriesBut;
    private javax.swing.JButton oldTalksBut;
    private javax.swing.JLabel propicLabel;
    private javax.swing.JLabel settingsBut;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JButton yourDaysBut;
    // End of variables declaration//GEN-END:variables
}
