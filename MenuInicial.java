import javax.swing.*;

public class MenuInicial {
   public static void main(String arg[]) {
      int resX = 640;
      int resY = 480;

      JFrame frame = new JFrame();
      JLabel titulo = new JLabel("Software de Gestão Hospitalar");
      JButton login = new JButton("Login");
      JButton cadastro = new JButton("Cadastro");
      JButton sair = new JButton("Sair");

      titulo.setBounds(resX/3, 0, resX/2, resY/2);
      frame.add(titulo);

      login.setBounds(resX/2 - 50, resY-200, 100, 50);
      cadastro.setBounds(resX/2 - 50, resY-150, 100, 50);
      sair.setBounds(resX/2 - 50, resY-100, 100, 50);
      frame.add(login);
      frame.add(cadastro);
      frame.add(sair);

      frame.setTitle("Software de Gestão Hospitalar - Menu Inicial");
      frame.setSize(resX, resY);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(null);
      frame.setVisible(true);
   }
}
