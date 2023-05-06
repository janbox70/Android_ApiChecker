#!/usr/bin/python
# coding:utf-8
"""
    comments here
"""
import os
from sklearn.ensemble import RandomForestClassifier, GradientBoostingClassifier
from sklearn.neighbors import KNeighborsClassifier
from sklearn import tree, svm, linear_model
from catboost import CatBoostClassifier
from sklearn.naive_bayes import BernoulliNB
from sklearn.metrics import accuracy_score, recall_score, precision_score, f1_score
from sklearn.model_selection import KFold
import numpy as np
import lightgbm as lgb

import cPickle as pkl
__author__ = 'apichecker'

if __name__ == "__main__":
    with open("apichecker.pkl") as pklfile:
        X, y = pkl.load(pklfile)
        y = [int(_) for _ in y]
        total_count = len(X)
        black_count = len(filter(lambda _: _ == 1, y))
        print("Total line %d, Black: %d" % (total_count, black_count))
        freq_counter = {}
        black_freq_counter = {}
        for x_line, y_line in zip(X, y):
            for i, feature in enumerate(x_line):
                if feature == 1:
                    if i not in freq_counter:
                        freq_counter[i] = 1
                        black_freq_counter[i] = 0
                    else:
                        freq_counter[i] += 1

                    if y_line == 1:
                        black_freq_counter[i] += 1
        for i in ragne(1,9):
            kf = KFold(n_splits=10)
            round = 1
            X = np.array(X)
            y = np.array(y)
            for train_index, test_index in kf.split(X, y):
                round += 1
                X_train, X_test = X[train_index], X[test_index]
                y_train, y_test = y[train_index], y[test_index]

                if i == 1:
                    clf = BernoulliNB()
                elif i == 2:
                    clf = RandomForestClassifier(n_estimators=15)
                elif i == 3:
                    clf = tree.DecisionTreeClassifier()
                elif i == 4:
                    clf = LinearRegression()
                elif i == 5:
                    clf = KNeighborsClassifier(n_neighbors=5,weights=’uniform’, algorithm=’auto’)
                elif i == 6:
                    clf = svm.SVC(gamma='auto')
                elif i == 7:
                    clf = MLPClassifier(hidden_layer_sizes=(100), solver=’adam’, alpha=0.0001)
                elif i == 8:
                    clf = MLPClassifier(hidden_layer_sizes=(100,75,50,20),solver='adam', alpha=0.0001)
                else:
                    clf = GradientBoostingClassifier(n_estimators=100, learning_rate=0.1, max_depth=3, random_state=0)
                
                print("Training Classification Model %d", i)
                clf.fit(X_train, y_train)
                #pkl.dump(clf, model_file)
                predict = clf.predict(X_test)
                print predict

                print("Precision %f" % precision_score(y_test, predict))
                print("RECALL %f" % recall_score(y_test, predict))
                break
        pass