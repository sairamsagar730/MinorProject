// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

    import javax.swing.*;
    import javax.swing.border.EmptyBorder;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.io.*;


public class TextEditor implements ActionListener {

            //Declaring the properties of text editor
            JFrame frame;

            JMenuBar menuBar;

            JMenu file,edit;

            //file menu items
            JMenuItem newFile,openFile,saveFile;
            //edit menu items
            JMenuItem cut,copy,paste,selectAll,close;

            JTextArea textArea;
            TextEditor() {
                frame = new JFrame();

                menuBar = new JMenuBar();
                // Initialize textarea
                textArea = new JTextArea();

                //Initialize menu s
                file = new JMenu("File");
                edit = new JMenu("Edit");

                //Initialize menu items
                newFile = new JMenuItem("New Windows");
                openFile = new JMenuItem("Open");
                saveFile = new JMenuItem("Save");

                //now we need to add action listeners
                newFile.addActionListener(this);
                openFile.addActionListener(this);
                saveFile.addActionListener(this);

                file.add(newFile);
                file.add(openFile);
                file.add(saveFile);

                // initialize edit menu items
                cut = new JMenuItem("Cut");
                copy = new JMenuItem("Copy");
                paste = new JMenuItem("Paste");
                selectAll = new JMenuItem("Select All");
                close = new JMenuItem("Close");

                //now we need to add action listeners
                cut.addActionListener(this);
                copy.addActionListener(this);
                paste.addActionListener(this);
                selectAll.addActionListener(this);
                close.addActionListener(this);
                // adding edit menu items to menu
                edit.add(cut);
                edit.add(copy);
                edit.add(paste);
                edit.add(selectAll);
                edit.add(close);

                // adding menus to the menuBar
                menuBar.add(file);
                menuBar.add(edit);

                //set menuBar to menu
                frame.setJMenuBar(menuBar);

                //create content pane
                JPanel panel=new JPanel();
                panel.setBorder(new EmptyBorder(5,5,5,5));
                panel.setLayout(new BorderLayout());

                //adding textArea to panel
                panel.add(textArea,BorderLayout.CENTER);

                //create scroll pane
                JScrollPane scrollPane=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                //Add Scroll pane to panel
                panel.add(scrollPane);
                //adding panel to frame
                frame.add(panel);


                //adding dimensions to the frame
                frame.setBounds(100, 100, 500, 500);
                frame.setVisible(true);
                frame.setLayout(null);
                frame.setTitle("Text Editor By SaiRam");
            }
            @Override
             public void actionPerformed(ActionEvent actionevent) {

                if(actionevent.getSource()==cut){
                    textArea.cut();
                }
                if(actionevent.getSource()==copy){
                    textArea.copy();
                }
                if(actionevent.getSource()==paste){
                    textArea.paste();
                }
                if(actionevent.getSource()==selectAll){
                    textArea.selectAll();
                }
                if(actionevent.getSource()==close){
                    System.exit(0);
                }
                if(actionevent.getSource()==newFile){
                    TextEditor textEditor=new TextEditor();
                }
                if(actionevent.getSource()==openFile){
                    //it has to open a file chooser
                    JFileChooser fileChooser=new JFileChooser("C:");
                    int chooseOption=fileChooser.showOpenDialog(null);
                    //if we have clicked on open button then
                    if(chooseOption==JFileChooser.APPROVE_OPTION){
                        //we are getting selected file

                        File file=fileChooser.getSelectedFile();
                        //Get the path of selected file

                        String filePath=file.getPath();
                        try {
                            //Initialize fileReader
                            FileReader fileReader=new FileReader(filePath);
                            //Initialize bufferReader
                            BufferedReader bufferedReader=new BufferedReader(fileReader);
                         String everyLine = "", output ="";
                            //read contents of a file line by line
                            while ((everyLine=bufferedReader.readLine())!=null){
                                output+=everyLine+"\n";
                            }
                            //set the output String to the textArea
                            textArea.setText(output);

                        } catch (IOException fileNotFoundException){
                           fileNotFoundException.printStackTrace();
                        }
                    }
                }
                if(actionevent.getSource()==saveFile){
                    //Initialize file picker
                    JFileChooser fileChooser=new JFileChooser("C:");
                    //get choose option from file chooser
                    int chooseOption =fileChooser.showSaveDialog(null);
                    if(chooseOption==JFileChooser.APPROVE_OPTION){
                        File file=new File(fileChooser.getSelectedFile().getAbsolutePath()+".txt");
                        try{
                            //initialize file writer
                            FileWriter fileWriter=new FileWriter(file);
                            //initialize BufferedWriter
                            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
                            //write contents of text Area to file
                            textArea.write(bufferedWriter);
                            bufferedWriter.close();
                        }
                        catch (IOException ioException){
                            ioException.printStackTrace();
                        }

                    }
                }

            }


            public static void main(String[] args) {

                TextEditor textEditor = new TextEditor();

            }
        }
