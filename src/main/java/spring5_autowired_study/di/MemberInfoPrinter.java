package spring5_autowired_study.di;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {
	private MemberDao memberDao;
	private MemberPrinter printer;

	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	@Autowired
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if (member == null) {
			throw new MemberNotFoundException();
		}
		printer.print(member);
		System.out.println();
	}
	

}