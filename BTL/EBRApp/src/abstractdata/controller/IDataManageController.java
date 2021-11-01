package abstractdata.controller;

public interface IDataManageController<T> {
//	public void create(T t);
//
//	public void read(T t);
//
//	public void delete(T t);
//
//	public void update(T t);

	public void onAct(T t);
}
