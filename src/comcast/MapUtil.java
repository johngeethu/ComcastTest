package comcast;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Stream;


public class MapUtil {
	
	  /*  public static <K, V extends Comparable<? super V>> Map<K, V> 
	        sortByValue( Map<K, V> map )
	    {
	        List<Map.Entry<K, V>> list =
	            new LinkedList<Map.Entry<K, V>>( map.entrySet() );
	        Collections.sort( list, new Comparator<Map.Entry<K, V>>()
	        {
	            public int compare( Map.Entry<K, V> o1, Map.Entry<K, V> o2 )
	            {
	                return (o1.getValue()).compareTo( o2.getValue() );
	            }
	        } );

	        Map<K, V> result = new LinkedHashMap<K, V>();
	        for (Map.Entry<K, V> entry : list)
	        {
	            result.put( entry.getKey(), entry.getValue() );
	        }
	        return result;
	    }*/
	    
	    public static <K, V extends Comparable<? super V>> Map<K, V> 
	    sortByValue( Map<K, V> map )
	    {
	      Map<K,V> result = new LinkedHashMap<>();
	     Stream <Entry<K,V>> st = map.entrySet().stream();

	     st.sorted(Comparator.comparing(e -> e.getValue()))
	          .forEach(e ->result.put(e.getKey(),e.getValue()));

	     return result;
	    }
	}


