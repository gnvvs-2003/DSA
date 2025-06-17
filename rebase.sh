#!/bin/bash
git pull --rebase origin main
if [ $? -eq 0 ]; then
  git push origin main
else
  echo "Rebase failed. Resolve conflicts and run: git rebase --continue"
fi
