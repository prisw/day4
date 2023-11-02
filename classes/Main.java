package day4.classes;

public class Main {

    public static void main (String [] args) {

        if (args.length <= 0) {
            System.err.println("Missing book csv");
            System.exit(1);
        }

        System.out.printf("Processing %s\n", args[0]);

        try (FileReader fr = new FileReader(args[0])) {
            BufferedReader br = new BufferedReader (fr);
             // or can use the ReadLine function and throw the first line

            Map<String, List<Book>> classified = br.lines()
                .skip(1) //skip the first line as it is a title line
                .map(row -> row.trim().split(","))

                //string[] -> book
                 //return the value you want,example:publisher by using groupingby function
                .map(fields -> new Book(fields[COL_TITLE], fields[COL_PUBLISHER]))
                .collect(Collectors.groupingBy(book -> book.getPublisher()));

            for(String publisher: classified.keySet()) {
                System.out.printf("%s/n", publisher);
                List<Book> books = classified.get(publisher);
                System.out.printf("%s (%d)\n", publisher,books.size());
                for(Book book: books)
                System.out.printf("\t%s/n", book.getTitle());
            }
            
           
        }

    }
}