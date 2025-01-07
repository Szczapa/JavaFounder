import java.io.*;

public class IOApp {

    public static void main(String[] args) throws IOException {

        int javaLineCounter = 0;
        int javaWordCounter = 0;

        String ReadPath = "textDemo.txt";

        String writePath = "textWrite.txt";
        try(BufferedReader reader = new BufferedReader(new FileReader(ReadPath))){
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);

                if(line.contains("Java")){
                    javaLineCounter++;
                }

               String[] parts = line.split("\\bJava\\b");
                javaWordCounter+=parts.length-1;
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        if (javaWordCounter > 0 ) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(writePath))){
                writer.write("Il y a " + javaWordCounter+ " le mot Java dans le dossier\n");
                writer.write("Et " + javaLineCounter + " mot contenant l'occurence Java dans le dossier");
            }
        }
    }
}

/*
Créez un programme Java qui :

- Lit un fichier texte ligne par ligne.
- Compte le nombre de lignes qui contiennent le mot "Java".
- Écrit le résultat dans un autre fichier nommé result.txt.
 */