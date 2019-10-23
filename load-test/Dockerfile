FROM python:3

WORKDIR /usr/src/app

COPY requirements.txt ./
RUN pip install --no-cache-dir -r requirements.txt

COPY my_script.py .

CMD [ "python", "./my_script.py" ]

