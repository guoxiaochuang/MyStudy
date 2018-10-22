package com.readbook.effectivejava.chapter6.article30;

// Enum type with constant-specific method implementations
public enum Operation {
	PLUS {
		double apply(double x, double y) {
			return x + y;
		}
	},
	MINUS {
		double apply(double x, double y) {
			return x - y;
		}

	},
	TIMES {

		double apply(double x, double y) {
			return x * y;
		}

	},
	DIVIDE {

		double apply(double x, double y) {
			return x / y;
		}

	};

	/**
	 * @Title: apply 
	 * @Description: 抽象方法，由不同的枚举值提供不同的实现 
	 * @param @param x
	 * @param @param y
	 * @param @return    设定文件 
	 * @return double    返回类型 
	 * @throws
	 */
	abstract double apply(double x, double y);
}
