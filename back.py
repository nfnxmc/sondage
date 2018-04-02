from flask import Flask 
from flask import request
from flask import jsonify
from flask_cors import CORS

app = Flask(__name__)
CORS(app)
users = []

@app.route("/hello", methods=['GET', 'POST'])
def hello():
    name = request.args['name']
    return "Hello " + name

@app.route("/login", methods=['GET', 'POST'])
def login():
    print("user => " ,request.args['user'])
    users.append(request.args['user'])
    print(users)
    return jsonify("{xhr_token:hxchgxchgxchjxcjhgcxjhvcxjhxcjh}")

@app.route('/register', methods=['GET', 'POST'])
def register():
    print("user => " ,request.args['user'])
    users.append(request.args['user'])
    return jsonify("{xhr_token:hxchgxchgxchjxcjhgcxjhvcxjhxcjh}")

if __name__ == '__main__':
    app.run(debug=True)
