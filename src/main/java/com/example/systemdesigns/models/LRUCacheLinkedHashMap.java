package com.example.systemdesigns.models;

import java.util.LinkedHashMap;

public class LRUCacheLinkedHashMap<K,V> extends LinkedHashMap<K,V> {

	private int size;
	
	private LRUCacheLinkedHashMap(int size){
		super(size,0.75f,true);
		this.size=size;
		
	}
	
	public static <K, V> LRUCacheLinkedHashMap<K,V> newInstance(int size){
		return new LRUCacheLinkedHashMap<>(size);
	}
	
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		return size()>size;
	}
}
