package Bank.account;

import java.util.ArrayList;
import java.util.List;

public class AccountNumberCreate {
    private static boolean exists(int n[], int index) {
        for (int i = 0; i < n.length; i++) {
            if (n[i] == index)
                return true;
        }
        return false;
    }

    public int accountNumberCreateRandom() {
        int result = 0;
        int n[] = new int[1];
        int index = 0;
        for(int i = 0; i<n.length;i++) {
            do {
                index = (int)(Math.random()*1000000000);
            }while(exists(n,index));
            n[i] = index;
        }
        for(int i = 0; i<1; i++)
            result = n[i];

        return result;
    }

}



