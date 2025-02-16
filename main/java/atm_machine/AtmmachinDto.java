package atm_machine;

public class AtmmachinDto {

	private Integer accno;
	private Integer senaccno;
	private Integer recaccno;
	public Integer getSenaccno() {
		return senaccno;
	}
	public void setSenaccno(Integer senaccno) {
		this.senaccno = senaccno;
	}
	public Integer getRecaccno() {
		return recaccno;
	}
	public void setRecaccno(Integer recaccno) {
		this.recaccno = recaccno;
	}
	private String name;
	private Integer pin;
	private Double bal;
	private int amount;
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Integer getAccno() {
		return accno;
	}
	public void setAccno(Integer accno) {
		this.accno = accno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPin() {
		return pin;
	}
	public void setPin(Integer pin) {
		this.pin = pin;
	}
	public Double getBal() {
		return bal;
	}
	public void setBal(Double bal) {
		this.bal = bal;
	}
	
}
