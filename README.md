# OSD Group Proj

## Investment analysis system

* Coursework concerns management + analysis of investments.

* An investor may purchase bonds. A bond has a term (number of years to expiry), coupon (percentage of investment, paid to investor at regular intervals), frequency of payments. Bonds have names, eg. “UK government bond” and purchase date.
* Assume frequency = 1 per year, investment = 100.

* Investors receive back invested sum at term, + final coupon payment.

>Eg., invest £100 in bond b paying 10% coupon annually for 5 years. 4 payments of £10, one of £110.
>System enables new bonds to be defined + added to investor’s portfolio.

* Bonds have a price: investor pays this with sum invested

* System should compute and display the payout of all bonds: sum of payments. £150 in example.

System should compute + display bond values: sum of discounted payments,
using inflation rate r :

>Eg., £10 1 year in future, with 5% inflation, is worth 10/1.05 today = £9.52.

System computes discount for each payment, and hence value of bond. In
example, value is £121.65 for r = 0.05.

* For each bond, system should calculate + show its Macaulay duration for
rate r.

> In example, 4.25 years for r = 0.05

* For each bond, system should compute + show its internal rate of return:
the r such that.
