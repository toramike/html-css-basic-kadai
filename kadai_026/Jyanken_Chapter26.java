package kadai_026;

import java.util.HashMap;
import java.util.Scanner;

public class Jyanken_Chapter26 {

	private String[] moves = { "r", "s", "p" };
	private HashMap<String, String> gameMap;
	private HashMap<String, String> gameRules;

	//	コンストラクタ
	public Jyanken_Chapter26() {
		this.gameMap = new HashMap<>();
		this.gameRules = new HashMap<>();

		this.gameMap.put("r", "グー");
		this.gameMap.put("s", "チョキ");
		this.gameMap.put("p", "パー");

		this.gameRules.put("グー対グー", "あいこです");
		this.gameRules.put("グー対チョキ", "自分の勝ちです");
		this.gameRules.put("グー対パー", "自分の負けです");
		this.gameRules.put("チョキ対グー", "自分の負けです");
		this.gameRules.put("チョキ対チョキ", "あいこです");
		this.gameRules.put("チョキ対パー", "自分の勝ちです");
		this.gameRules.put("パー対グー", "自分の勝ちです");
		this.gameRules.put("パー対チョキ", "自分の負けです");
		this.gameRules.put("パー対パー", "あいこです");
	}

	//	メソッド 自分のじゃんけんの手を入力
	public String getMychoice() {
		System.out.println("自分のじゃんけんの手を入力しましょう");
		System.out.println("グーはrockのrを入力しましょう");
		System.out.println("チョキはscissorsのsを入力しましょう");
		System.out.println("パーはpaperのpを入力しましょう");

		Scanner sc = new Scanner(System.in);
		boolean judge = false;
		String input = null;

		//		正しい入力があるまで再入力させる
		while (!judge) {
			input = sc.next();

			//			入力が正しいか判定
			for (String s : moves) {
				if (input.equals(s)) {
					judge = true;
					break;
				}
			}
			if (!judge) {
				System.out.println("入力が間違っています。もう一度入力してください");
			}
		}
		sc.close();
		return input;
	}

	//	メソッド 対戦相手のじゃんけんの手を乱数で選ぶ
	public String getRandom() {
		//		ランダムに選んで返す
		int i = (int) (Math.random() * 3);
		return this.moves[i];
	}

	//	メソッド　じゃんけんを行う
	public void playGame(String mine, String opponent) {

		String myMove = this.gameMap.get(mine);
		String opponentMove = this.gameMap.get(opponent);

		System.out.println("自分の手は" + myMove + "相手の手は" + opponentMove);

		String result = myMove + "対" + opponentMove;
		System.out.println(this.gameRules.get(result));

	}

}
