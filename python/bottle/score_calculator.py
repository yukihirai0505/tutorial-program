# -*- coding: utf-8 -*-
from bottle import route, run

db_name = "fprank"
host = "localhost"
username = "root"
passwd = "root"


@route('/score/<tag>')
def score(tag):
    import mysql.connector
    connect = mysql.connector.connect(db=db_name, host=host, port=3306, user=username, passwd=passwd)

    cur = connect.cursor()
    cur.execute('select * from instagram_tags where tag_name = "%s"' % tag)
    score = cur.fetchall()

    print(score[0][0])

    return score[0][0]
