package util;

import android.os.Parcel;
import android.os.Parcelable;

public class Pais implements Parcelable{
	
	int id;
	String nombre;
	
	//Constructor carton-piedra.
	public Pais(String nom)
	{
		nombre = nom;
	}
	
	private Pais(Parcel in) {
        this.id = in.readInt();
        this.nombre = in.readString();
    }
	
	public static final Parcelable.Creator<Pais> CREATOR
	    = new Parcelable.Creator<Pais>() {
		public Pais createFromParcel(Parcel in) {
		    return new Pais(in);
		}
		
		public Pais[] newArray(int size) {
		    return new Pais[size];
		}
	};

	
	public String getNombre() {
		return nombre;
	}
	
	public Pais(int id, String nombre) {
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
	
	public Pais(){}

	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Pais)
		{
			Pais p = (Pais)o;
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
