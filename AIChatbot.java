import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class AIChatbot extends JFrame {
    private JTextArea chatArea;
    private JTextField inputField;
    private HashMap<String, String> responses;

    public AIChatbot() {
        // Step 1: Prepare responses
        responses = new HashMap<>();
        responses.put("hi", "Hello!");
        responses.put("hello", "Hi there!");
        responses.put("how are you", "I'm just a bot, but I'm doing great!");
        responses.put("what is ai", "AI means Artificial Intelligence.");
        responses.put("bye", "Goodbye! Have a nice day.");
        responses.put("thanks", "You're welcome!");
        responses.put("your name", "I'm AIChatbot, your virtual friend.");

        // Step 2: Create GUI
        setTitle("AI Chatbot");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        inputField = new JTextField();
        add(inputField, BorderLayout.SOUTH);

        // Step 3: Action on Enter key
        inputField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userInput = inputField.getText().toLowerCase().trim();
                chatArea.append("You: " + userInput + "\n");

                String response = "Sorry, I don't understand.";
                for (String key : responses.keySet()) {
                    if (userInput.contains(key)) {
                        response = responses.get(key);
                        break;
                    }
                }

                chatArea.append("Bot: " + response + "\n");
                inputField.setText("");
            }
        });

        // Step 4: Make window visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new AIChatbot();
    }
}
