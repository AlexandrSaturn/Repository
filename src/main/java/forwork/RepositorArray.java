package forwork;

public class RepositorArray {

    private Person[] arr;
    int lengthA;

    RepositorArray(){arr=null;}

    public void add(Person p) {
        if (arr == null) {
            lengthA = 1;
            arr = new Person[10];
            arr[lengthA - 1] = new Person(p);
        } else {
            lengthA++;
            if (lengthA - 1 < arr.length)
                arr[lengthA - 1] = new Person(p);
            else {
                Person[] new_arr = new Person[(int) (arr.length * 1.5)];

                for (int i = 0; i < arr.length; i++)
                    new_arr[i] = new Person(arr[i]);

                new_arr[arr.length] = new Person(p);

                arr = new_arr;
            }

        }
    }


    public void println(){
        if (arr!=null)
            for (int i=0;i<lengthA;i++)
                arr[i].println();
    }

    public Person getPerson(int id){
        boolean search = false;
        int i=0;
        while (!search && i<lengthA){
            search = (arr[i].getId()==id);
            i++;
        }
        if (search)
            return arr[i-1];
        else
            return null;
    }

    private int getIndex(Person p){
        boolean search = false;
        int i=0;
        while (!search && i<lengthA){
            search = (arr[i].equals(p));
            i++;
        }
        if (search)
            return i-1;
        else
            return -1;
    }

    private int getIndex(int id){
        boolean search = false;
        int i=0;
        while (!search && i<lengthA){
            search = (arr[i].getId()==id);
            i++;
        }
        if (search)
            return i-1;
        else
            return -1;
    }

    public void deletePerson(int id){
        int index=getIndex(id);

        if (index > -1){
            for (int i=index;i<lengthA-1;i++)
                arr[i].Copy(arr[i+1]);
        }
        lengthA--;
        arr[lengthA]=null;
    }

    public void deletePerson(Person p){
        int index=getIndex(p);

        if (index > -1){
            for (int i=index;i<lengthA-1;i++)
                arr[i].Copy(arr[i+1]);
        }
        lengthA--;
        arr[lengthA]=null;
    }




    

}

