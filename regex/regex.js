// practice /regexp?/

// part1

var s = '@taguchi, @fkoji, @dotinstall';
var rs = s.match(/taguchi/);

if (rs) {
  console.log('マッチしました!')
}

// part2

// meta character

// [abc] => a or b or c
// [a-c] => a to c
// [^abc] => not a or not b or not c

var s = '@teguchi, @fkoji, @dotinstall';
var rs = s.match(/t[^ao]guchi/);

if (rs) {
  console.log('マッチしました!')
}

// part3

// . => any one word
// ^ => beginning of line * if you use ^ inside [] it means not ~
// $ => end of line

var s = '@teguchi, @fkoji, @dotinstall';
var rs = s.match(/^@t.guchi.*l$/);

if (rs) {
  console.log('マッチしました!')
}

// part4

// {} => repeat num for before character
// 0{2} => 00
// @{2,} => 00,000,00000
// @{2,4} => 00, 000, 0000

// [a-z]{5}
// [a-z]{3,5}

// part5

// a? => 0 or 1 =>  , a
// a* => 0 or more => , a, aaaa, aaaaaa
// a+ => 1 or more => a, aaa, aaaaaa

// part6

// () => (abc)* => abc, abcabc
// |  => or => (abc|def) => abc, def

// part7

// \n => break line
// \t => tab
// \d => number [0-9]
// \w => english number _ [A-Za-z0-9_]
// \s => space or tab
// \(meta caharacter) => meta => \/

// part8

// javascript options

// i => uppercase and lowercase
// g => return all match element
// m => apply multi line

// part9

// ? after * + means minimum match

// *?
// +?

var s = 'taguchi@dotinstall.com, fkoji@dotinstall.com, admin@dotinstall.com';
var rs = s.match(/.+@dotinstall.com/);

console.log(rs);
// => ["taguchi@dotinstall.com, fkoji@dotinstall.com, admin@dotinstall.com", index: 0, input: "taguchi@dotinstall.com, fkoji@dotinstall.com, admin@dotinstall.com"]

if (rs) {
  console.log('マッチしました!')
}

var s = 'taguchi@dotinstall.com, fkoji@dotinstall.com, admin@dotinstall.com';
var rs = s.match(/.+?@dotinstall.com/);

console.log(rs);
// => ["taguchi@dotinstall.com", index: 0, input: "taguchi@dotinstall.com, fkoji@dotinstall.com, admin@dotinstall.com"]

if (rs) {
  console.log('マッチしました!')
}

// part10

// () RegExp

// you can get the inside of () after

var s = 'taguchi@dotinstall.com';
var rs = s.match(/(.+?)@dotinstall(.com)/);

console.log(RegExp.$1);
// => taguchi
console.log(RegExp.$2);
// => .com

var rs = s.match(/((.+?)@dotinstall(.com))/);
// => taguchi@dotinstall.com

console.log(RegExp.$1);

// but now RegExp is deprecated https://developer.mozilla.org/ja/docs/Web/JavaScript/Reference/Deprecated_and_obsolete_features
// so you should use return object

console.log(RegExp.$1);
console.log(rs[1]);

// part11

// match twitterId

var s = '@yukihirai0505';
var rs = s.match(/^@([A-Za-z0-9_]{1,15})$/);
console.log(rs[1]);

// part12

// extract tag

var s = '<title>yeah!yeah!!</title>';
var rs = s.match(/<title>([^<]+)<\/title>/);
console.log(rs[1]);

// part13

// datetime to japanese expression

var s = '2012-03-24';
var rs = s.match(/(\d{4})[-\/](\d{2})[-\/](\d{2})/);
console.log(rs[1] + '年' + rs[2] + '月' + rs[3] + '日');
