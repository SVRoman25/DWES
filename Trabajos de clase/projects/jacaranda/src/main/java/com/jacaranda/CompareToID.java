package com.jacaranda;

import java.util.Comparator;
import com.jacaranda.entity.*;

public class CompareToID implements Comparator<Customer>{

	@Override
	public int compare(Customer cc1, Customer cc2) {
		
		if(cc1.getId()>cc2.getId()){
            return 1;
        }else if(cc1.getId()>cc2.getId()){
            return 0;
        }else{
            return -1;
        }
    }
	

}
