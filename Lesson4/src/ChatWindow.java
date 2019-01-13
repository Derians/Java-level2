import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ivan Chaykin
 * Date: 25.12.2018
 * Time: 10:42
 */
public class ChatWindow extends JFrame {

    public ChatWindow() throws HeadlessException {

        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 100, 800, 800);
        setResizable( false );
        setLocationRelativeTo( null );

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 0));

        JPanel chatPanel = new JPanel();
        chatPanel.setLayout(new BorderLayout());
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(textArea);
        chatPanel.add(scrollPane);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        JTextField inputText = new JTextField();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 5, 0, 5);

        inputPanel.add(inputText, gbc);

        JButton submit = new JButton("send");

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!inputText.getText().isEmpty()) {
                    textArea.append(inputText.getText() + "\n");
                    inputText.setText("");
                }
                inputText.grabFocus();
            }
        });

        inputPanel.add(submit);

        mainPanel.add(chatPanel, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setVisible(true);
        inputText.grabFocus();

    }
}
