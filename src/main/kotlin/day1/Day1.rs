use std::collections::LinkedList;
use std::fs::File;
use std::io::{self, BufRead};
use std::path::Path;
use itertools::Itertools;

fn main() {
    if let Ok(lines) = read_lines("src/main/resources/day1") {
        let mut list = LinkedList::new();
        let mut current_list: LinkedList<i32> = LinkedList::new();
        for result in lines {
            if let Ok(line) = result {
                if line == "" {
                    list.push_front(current_list.clone());
                    current_list.clear();
                } else {
                    current_list.push_front(line.parse().unwrap());
                }
            }
        }

        let totals: _ = list.into_iter().map(|x| x.iter().sum::<i32>()).collect::<LinkedList<_>>();
        println!("{}", totals.iter().sorted().rev().take(3).sum::<i32>());
    }
}

fn read_lines<P>(filename: P) -> io::Result<io::Lines<io::BufReader<File>>>
    where P: AsRef<Path>, {
    let file = File::open(filename)?;
    Ok(io::BufReader::new(file).lines())
}