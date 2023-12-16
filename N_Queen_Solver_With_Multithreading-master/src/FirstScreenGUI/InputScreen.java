package FirstScreenGUI;

import static FirstScreenGUI.InputScreen.CAN_STOP;
import static FirstScreenGUI.InputScreen.N;
import static FirstScreenGUI.InputScreen.Submit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import N_queens_solver_package.ThreadSolver;


public class InputScreen extends javax.swing.JFrame implements ActionListener {

    public static javax.swing.JLabel Title = new javax.swing.JLabel();
    public static javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
    public static javax.swing.JTextField input = new javax.swing.JTextField();

    public static javax.swing.JButton Submit = new javax.swing.JButton();
    public static javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
    public static javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
    public static javax.swing.JLabel solValue = new javax.swing.JLabel();
    public static int N;
    public static volatile boolean CAN_STOP = false;

    /**
     * Creates new form input
     */
    public InputScreen() {
        initComponents();
    }

    public static boolean CAN_STOP_window() {
        return CAN_STOP;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        input.addKeyListener(new KeyListenerObject(input,this));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Title.setFont(new java.awt.Font("Courgette", 0, 48)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("N-Queens Solver");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Enter N:");

        input.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });

        Submit.setBackground(new java.awt.Color(102, 102, 102));
        Submit.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        Submit.setText("Submit");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        if (CAN_STOP) {
            jLabel3.setText("Solutions are found... Please Wait");
        }

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, Title, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(0, 0, Short.MAX_VALUE)
                                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(229, 229, 229))
                        .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(layout.createSequentialGroup()
                                                .add(130, 130, 130)
                                                .add(36, 36, 36)
                                                .add(solValue)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(jLabel3))
                                        .add(layout.createSequentialGroup()
                                                .add(57, 57, 57)
                                                .add(jLabel1)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                                .add(input, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 385, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(layout.createSequentialGroup()
                                                .add(232, 232, 232)
                                                .add(Submit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(layout.createSequentialGroup()
                                                .add(229, 229, 229)
                                        ))
                                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(Title)
                                .add(169, 169, 169)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jLabel1)
                                        .add(input, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(18, 18, 18)
                                .add(Submit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(57, 57, 57)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jLabel3)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                                .add(solValue)))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jLabel2)
                                .add(41, 41, 41)
                                .addContainerGap(55, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(600, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void ShowActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void inputActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {
        int n = 0;
        if (evt.getSource() == Submit) {
            String input = this.input.getText();
            try {
                n = Integer.parseInt(input);
            } catch (Exception e) {
            }
            if (!(n == (int) n) || n < 4 || n > 15) {
                JOptionPane.showMessageDialog(this, "You should enter an integer number bigger than 3 and smaller than 16".toUpperCase());
                this.input.setText("");
            } else {
                N = n;
                CAN_STOP = true;
            }
        }
    }

                     
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
