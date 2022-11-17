import java.time.LocalTime;
import java.util.*;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class TST {
    public int wpm(double numchars,double seconds) //Function to calculate words per minute with the number of characters and time taken in seconds as parameters
    {
        int w=(int)(((numchars/5)/seconds)*60); //Formula to calculate words per minute
        return w; //returns the calculated words per minute to the calling function

    }
    public int cpm(double numchars,double seconds) //Function to calculate characters per minute with the number of characters and time taken in seconds as parameters
    {
        int c=(int)((numchars/seconds)*60); //Formula to calculate characters per minute
        return c; //returns the calculated characters per minute to the calling function

    }
    public float accuracy(String teststring,String typedwords) //Function to calculate the accuracy of the typed words with the given string and typed words as parameters
    {
        String[] ts=teststring.split(" "); //split the teststring into array of words
        String[] tw=typedwords.split(" "); //split the typedwords into array of words
        int correctwords=0; //variable to count the number of correct words and is initialized to 0
        float ac; //variable to store the accuracy rate
        for(int i=0;i<ts.length;i++) //traverse through the words in teststring array
        {
            if(tw.length<=i) //To maintain the loop count upto the length of the typed words
                break;
            else
            {
                if(ts[i].equals(tw[i])) //check if the typed word matches the given string's word
                    correctwords=correctwords+1; //if the condition is true, then increement the number of correct words by 1
            }
        }
        ac=(float)correctwords/(float)ts.length; //Formula to calculate the accuracy rate
        return (ac*100); //return the accuracy rate in percentage
    }

    public static void main(String[] args) throws InterruptedException { //main function
        String teststring=""; //variable to store the test string from which the typing speed is calculated
        String[] easy= {"elephant","an","apple","keyboard","anything","calender","shipment","movies","requirement","baggage","historical","ahead",
                "callous",
                "deliver",
                "disturbed",
                "difficult",
                "memorize",
                "idiotic",
                "immense",
                "useless",
                "friend",
                "birthday"}; //an array that stores random words to calculate the typing speed in a beginner level
        String[] medium= {"When I saw you standing there in the road, so beautiful, your hair flowing around you like morning mist, I couldn't let you walk away.",
                "It was beautiful in winter, but it would be much more so when the trees gained color",
                "If I were a tree, I would have no reason to love a human.",
                "Nature is like our mother who never scolds us unless we do anything wrong.",
                "Nature is our best friend. We should do plantation and nurturing to keep it healthy."};  //an array that stores random sentences to calculate the typing speed in an intermediate level
        String[] hard= {"  Engineers like to solve problems. If there are no problems handily available, they will create their own problems.      ",
                "There’s nothing I believe in more strongly than getting young people interested in science and engineering, for a better tomorrow, for all humankind. ",
                "Engineering is not only study of 45 subjects but it is moral studies of intellectual life. ",
                "Learn as if you will live forever, live like you will die tomorrow.",
                "It is only when we take chances, when our lives improve. The initial and the most difficult risk that we need to take is to become honest. "};  //an array that stores random sentences to calculate the typing speed in a professional level
        System.out.println("                                        WELCOME TO TYPING SPEED TEST"); //main heading
        TimeUnit.SECONDS.sleep(2); //Pause for 2 seconds and execute further commands
        System.out.println(); //next line
        System.out.println("                        Let's check your Typing speed in three different levels "); //sub heading-1
        TimeUnit.SECONDS.sleep(1); //Pause for 1 second and execute further commands
        System.out.println(); //next line
        Scanner scan=new Scanner(System.in); //Scanner object to take the inputs from the user
        Random rand=new Random(); //Random object to generate random numbers
        System.out.println("===============================================EASY=========================================:)"); //sub heading-2
        System.out.println();//next line
        for(int i=0;i<6;i++) //loop to generate random 6 words
        {
            teststring=teststring+easy[rand.nextInt(easy.length)]+" "; //select random 6 words from the easy array and concatenate to teststring
        }
        System.out.print(teststring); //print the teststring
        System.out.println();//next line
        double start=LocalTime.now().toNanoOfDay(); //a variable of type double which stores the current time in nano seconds before the user starts typing
        String typedwords=scan.nextLine(); //takes the input from the user and stores in the variable typedwords
        double end=LocalTime.now().toNanoOfDay(); //a variable of type double which stores the current time in nano seconds after the user finished typing
        double elapsedTime=end-start; // a variable to store the calculated duration taken to type the user's input
        double seconds=elapsedTime/1000000000.0; // converting nanoseconds to seconds
        double numchars=typedwords.length(); //a variable to store the number of words typed by the user
        TST t=new TST(); // an object of TST class used for calling the functions outside the class
        Float a=null; //An object of Float class initialized to null
        ArrayList<Float> alist=new ArrayList<Float>(Arrays.asList(a)); //An array list used for storing the values obtained from the functions
        float w=t.wpm(numchars, seconds); //calling the function wpm and storing the result in the float variable w
        float c=t.cpm(numchars, seconds); //calling the function cpm and storing the result in the float variable c
        float ac=t.accuracy(teststring,typedwords); // //calling the function accuracy and storing the result in the float variable ac
        alist.add(w); //adding the words per minute in the arraylist
        alist.add(c); //adding the characters per minute in the arraylist
        alist.add(Float.parseFloat(String.format("%.2f", ac))); //adding the formatted accuracy rate in the arraylist

        System.out.println();//next line

        System.out.println("-=========================================MEDIUM============================================:)");//to display the medium mode
        teststring=medium[rand.nextInt(5)];// to intialize the test string to medium mode
        System.out.print(teststring+" ");//to print the test string
        System.out.println();// next line
        start=LocalTime.now().toNanoOfDay();//to get the exact nanoseconds of the day
        typedwords=scan.nextLine();//
        end=LocalTime.now().toNanoOfDay();//to get the exact nanoseconds of the day after the user taps on enter
        elapsedTime=end-start;//to calculate the elapsed time
        seconds=elapsedTime/1000000000.0;//to convert the nanoseconds into seconds
        numchars=typedwords.length();//to get the number of character from user
        w=t.wpm(numchars, seconds);// formula to get the words per minute and is initialized to w
        c=t.cpm(numchars, seconds);//formula to get the characters  per minute and is initialized to c
        ac=t.accuracy(teststring,typedwords);//formula to get the accuracy of user and is initialized to ac
        alist.add(w);// w is added to the list
        alist.add(c);//c is added to the list
        alist.add(Float.parseFloat(String.format("%.2f", ac)));//ac is added to the list

        System.out.println();//next line

        System.out.println("==========================================HARD==============================================:)");//to display hard mode
        teststring=hard[rand.nextInt(5)];//to initialze the test string to medium mode
        System.out.print(teststring+" ");//print the test string
        System.out.println();//next line
        start=LocalTime.now().toNanoOfDay();//to get the exact nanoseconds of the day
        typedwords=scan.nextLine();//
        end=LocalTime.now().toNanoOfDay();//to get the exact nanoseconds of the day after the usr taps enter
        elapsedTime=end-start;//formula to calculate elapsed time
        seconds=elapsedTime/1000000000.0;//to convert nanoseconds into seconds
        numchars=typedwords.length();//to get the number of characters from user
        w=t.wpm(numchars, seconds);// formula to get the words per minute and is initialized to w
        c=t.cpm(numchars, seconds);//formula to get the characters  per minute and is initialized to c
        ac=t.accuracy(teststring,typedwords);//formula to get the accuracy of user and is initialized to ac
        alist.add(w);// w is added to the list
        alist.add(c);// c is added to the list
        alist.add(Float.parseFloat(String.format("%.2f", ac)));//ac is added to the list
        //Table headings
        System.out.println();System.out.println();System.out.println(); //next line x3
        System.out.print("                "+"WPM"+"             ");//to print wpm
        System.out.print("CPM"+"             ");//to print cpm
        System.out.print("ACCURACY(in %)");//to print accuracy
        System.out.println("              "+"REMARKS"+"                          ");//to print remarks
        System.out.println();//next line
        System.out.println("============================================================================================:)"); //horizontal line

        for(int i=1;i<alist.size();i++) //for loop to traverse through the elements of the arraylist
        {
            if((i-1)%3==0) //for every 3 values in the arraylist,there must be a line break
                System.out.println(); //next line
            if(i==1) //to add the first row heading as easy
                System.out.print("EASY"+"            "); //prints easy
            else if(i==4)//to add the second row heading as medium
                System.out.print("MEDIUM"+"          "); //prints medium
            else if(i==7)//to add the third row heading as hard
                System.out.print("HARD"+"            "); //prints hard
            System.out.print(alist.get(i)+"            ");//prints the values
            if(i%3==0) //to add remarks to the end of the row
            {
                if(alist.get(i)>=90)// checks if the accuracy is greater than 90
                {
                    System.out.println("AWESOME ,WELLDONE !");// then prints this message
                }
                else if(alist.get(i)>=70 && alist.get(i)<90)//checks if the accuracy is between 70 and 90
                {
                    System.out.println("GOOD,BUT STILL BOOM IT !");//then prints this message
                }
                else if (alist.get(i)>=50 && alist.get(i)<70)//checks if accuracy is between 50 and 70
                {
                    System.out.println("SATISFACTORY, COULD BE IMPROVED!");//then prints this message
                }
                else
                {
                    System.out.println("POOR.... NEEDS IMPROVEMENT!");//if the its below 50,prints this message
                }
            }


        }
        scan.close(); //scanner object closes

    }

}