package br.com.evertontrindade.h2connectionexample;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.evertontrindade.h2connectionexample.beans.LogDate;
import br.com.evertontrindade.h2connectionexample.repository.LogDateRepository;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class H2connectionExampleApplication extends JFrame{

	@Autowired
    private LogDateRepository repo;
	
	public H2connectionExampleApplication() {
        initUI();
    }

    private void initUI() {

    	JButton logButton = new JButton("Log");
        JButton quitButton = new JButton("Quit");

        quitButton.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });
        
        logButton.addActionListener((ActionEvent event) -> {
        	LogDate log = new LogDate();
        	log.setDate(Calendar.getInstance().getTime());
            repo.save(log);
        });
        
        setLayout(new FlowLayout());
        getContentPane().add(logButton);
        getContentPane().add(quitButton);

        setTitle("Quit button");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

	public static void main(String[] args) {

	    ConfigurableApplicationContext ctx = new SpringApplicationBuilder(H2connectionExampleApplication.class)
	            .headless(false).run(args);

	    EventQueue.invokeLater(() -> {
	    	H2connectionExampleApplication ex = ctx.getBean(H2connectionExampleApplication.class);
	        ex.setVisible(true);
	    });
	}
}
