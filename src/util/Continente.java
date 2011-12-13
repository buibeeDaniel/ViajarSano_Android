package util;

import java.util.Iterator;

import android.os.Parcel;
import android.os.Parcelable;

public class Continente implements Parcelable{
	
	int id;
	String nombre;
	
	//Constructor carton-piedra.
	public Continente(String nom)
	{
		nombre = nom;
	}
	
	public Continente(){}

	public Continente(Iterator<String> iterator) 
	{
	}

	
	private Continente(Parcel in) {
        this.id = in.readInt();
        this.nombre = in.readString();
    }
	
	public static final Parcelable.Creator<Continente> CREATOR
	    = new Parcelable.Creator<Continente>() {
		public Continente createFromParcel(Parcel in) {
		    return new Continente(in);
		}
		
		public Continente[] newArray(int size) {
		    return new Continente[size];
		}
	};

	
	public String getNombre() {
		return nombre;
	}
	
	public Continente(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Continente)
		{
			Continente p = (Continente)o;
			if(p.getNombre().equals(this.nombre))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.id);
		dest.writeString(this.nombre);
	}
}