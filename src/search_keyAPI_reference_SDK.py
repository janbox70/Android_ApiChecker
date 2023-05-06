#!/usr/local/bin/python
# coding:utf-8
import os
import re


def load_package_inclusive(path):
    android_packages_file = open(path)
    packages = android_packages_file.readlines()
    for i in range(len(packages)):
        packages[i] = packages[i].strip()
    android_packages_file.close()
    packages = set(packages)
    return packages


def load_class_inclusive(packages, source_dir):
    android_class_list = set()
    for package in packages:
        package_relative_route = package.replace('.', '/')
        package_absolute_path = os.path.join(source_dir, package_relative_route)
        if os.path.isdir(package_absolute_path):
            for android_class in os.listdir(package_absolute_path):
                android_class_path = os.path.join(package_absolute_path, android_class)
                if os.path.isfile(android_class_path) and os.path.splitext(android_class)[1] == '.java':
                    android_class = os.path.join(package_relative_route, android_class)
                    android_class = android_class.split('.')[0].replace('/', '.')
                    android_class_list.add(android_class)
    android_class_list.add('dalvik.bytecode.Opcodes')
    android_class_list.add('dalvik.bytecode.OpcodeInfo')
    android_class_list.add('dalvik.annotation.TestTarget')
    android_class_list.add('dalvik.annotation.TestTargetClass')
    android_class_list.add('dalvik.system.BaseDexClassLoader')
    android_class_list.add('dalvik.system.DexClassLoader')
    android_class_list.add('dalvik.system.DexFile')
    android_class_list.add('dalvik.system.InMemoryDexClassLoader')
    android_class_list.add('dalvik.system.PathClassLoader')
    return android_class_list


def load_key_api(file_path):
    api_set_file = open(file_path)
    apis = api_set_file.readlines()
    for i in range(len(apis)):
        apis[i] = apis[i].strip()
    api_set_file.close()
    print('load key api, size:', len(apis))
    return apis

def search_ref(packages, source_dir, apis):
    android_class_list = set()
    api_ref_count = {}
    for api in apis:
        api_ref_count[api] = 0
    for package in packages:
        package_relative_route = package.replace('.', '/')
        package_absolute_path = os.path.join(source_dir, package_relative_route)
        if os.path.isdir(package_absolute_path):
            for android_class in os.listdir(package_absolute_path):
                android_class_path = os.path.join(package_absolute_path, android_class)
                if os.path.isfile(android_class_path) and os.path.splitext(android_class)[1] == '.java':
                    android_class = os.path.join(package_relative_route, android_class)
                    android_class = android_class.split('.')[0].replace('/', '.')
                    android_class_file = open(android_class_path)
                    file_text = android_class_file.read()

                    for api in apis:
                        api_class = api.split(' ')[0]
                        api_method = api.split(' ')[1]
                        if api_class == android_class:
                            res = re.findall(api_method + '\(.*\);', file_text)
                            api_ref_count[api] = api_ref_count[api] + len(res)
                            #print 'inside:', len(res), res
                        else:
                            if re.search('import ' + api_class + ';', file_text) != None:
                                res = re.findall(api_method + '\(.*\);', file_text)
                                api_ref_count[api] = api_ref_count[api] + len(res)
                                #print 'outside:', len(res), res
                            elif api_class.find('java.lang') != -1:
                                res = re.findall(api_method + '\(.*\);', file_text)
                                api_ref_count[api] = api_ref_count[api] + len(res)
                                #print 'java lang outside:', len(res), res
                    android_class_file.close()

    api_ref_record_file = open('api_ref.txt', 'w')
    count = 0
    for api in api_ref_count:
        ref_count = api_ref_count[api]
        count = count + ref_count
        line = str(api) + '\t' + str(ref_count) + '\n'
        print(line)
        api_ref_record_file.write(line)
    api_ref_record_file.close()
    print(count)


if __name__ == '__main__':
    prefix = '/home/'
    source_path = os.path.join(prefix, 'sdk/sources/android-26')
    android_packages = load_package_inclusive('android_package.txt')
    apis = load_key_api('api_set.txt')
    search_ref(android_packages, source_path, apis)
